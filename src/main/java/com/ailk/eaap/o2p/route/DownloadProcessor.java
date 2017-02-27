/** 
 * Project Name:o2p-serviceAgent-core 
 * File Name:DownloadProcessor.java 
 * Package Name:com.ailk.eaap.op2.serviceagent.route.service 
 * Date:2014年9月25日下午4:28:04 
 * Copyright (c) 2014, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.o2p.route;  

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import com.ailk.eaap.o2p.common.Constant;
import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.o2p.common.security.SecurityUtil;
import com.ailk.eaap.o2p.util.file.filters.FileFilterExpression;
import com.ailk.eaap.o2p.util.file.local.FileSortUtil;
import com.ailk.eaap.o2p.util.file.remote.session.DownloadCallBack;
import com.ailk.eaap.o2p.util.file.remote.session.Session;
import com.ailk.eaap.o2p.util.file.remote.session.ftp.DefaultFtpSessionFactory;
import com.ailk.eaap.o2p.util.file.remote.session.http.HttpSession;
import com.ailk.eaap.o2p.util.file.remote.session.model.ExtAttr;
import com.ailk.eaap.o2p.util.file.remote.session.sftp.DefaultSftpSessionFactory;
import com.ailk.eaap.op2.common.EAAPException;
import com.ailk.eaap.op2.serviceagent.common.EOPDomain;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.route.service.EndpointProcessor;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.Endpoint;
import com.ailk.eaap.op2.bo.EndpointAttr;
import com.ailk.eaap.op2.bo.SerInvokeIns;
import com.ailk.eaap.op2.bo.TechImpl;
import com.asiainfo.integretion.o2p.serviceagent.cache.IMemcacheManageServ;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.SftpException;
import com.linkage.rainbow.util.StringUtil;

public class DownloadProcessor implements EndpointProcessor{
	
	private final static Logger logger = Logger.getLog(DownloadProcessor.class);
	private IMemcacheManageServ cacheService;
	
	private String downloadTempDir;

	private String decryMsg(String msg) {
		return SecurityUtil.getInstance().decryMsg(msg);
	}

	public MessageBO process(Endpoint endpoint, MessageBO msg)
			throws EAAPException {
		StringBuffer response = new StringBuffer();
		response.append("subpub file exchange").append(" <ENDPOINTID=").append(endpoint.getEndpointId()).append(">");
		
		if(logger.isInfoEnabled()){
			logger.info("#DownloadProcessor START#  SerInvokeInsName:{0} ,curryEndpointId:{1}",msg.getSerInvokeIns().getSerInvokeInsName(),endpoint.getEndpointId());
		}
		//存储记录未下载完成的文件
		Map<String, String> fileMap = new ConcurrentHashMap<String, String>();
		List<File> fileList = new ArrayList<File>();
		
		SerInvokeIns serInvokeIns = msg.getSerInvokeIns();
		Map<String,String> vmap = endpointValue(endpoint, serInvokeIns);
		
		String fileDirType = vmap.get(EndpointAttr.FILE_DIR_TYPE);
		String fileSortType = vmap.get(EndpointAttr.FILE_SORT_TYPE);
		String fileDir =vmap.get(EndpointAttr.LINK_FILE_DIR);
		int fileNum = Integer.valueOf(vmap.get(EndpointAttr.FILE_DOWNLOAD_LIMIT_NUM));
		String filterExpression = vmap.get(EndpointAttr.MESSAGE_RULE);
		String fileTempDir = vmap.get(EndpointAttr.FILE_TEMP_DIR);
		List<ExtAttr> moveFileInfos=msg.getMoveFileInfos();				//指定搬迁的文件信息
		try{
			if(logger.isDebugEnabled()) {
				logger.debug("serInvokeInsId:{0}, fileTempDir:{1}, fileNum:{2}, fileDirType:{3},fileDir:{4},filterExpression:{5},fileSortType:{6}", serInvokeIns.getSerInvokeInsId(),
						fileTempDir, fileNum, fileDirType,fileDir,filterExpression,fileSortType);
			}
			File tempDir = new File(fileTempDir);
			if(!tempDir.exists()){
				FileUtils.forceMkdir(tempDir);
			}
			if(msg.getMessageMap()!=null && msg.getMessageMap().size()>0 ){
				fileMap = msg.getMessageMap();
			}
			
			File[] fileArray = null;
			
			//本地文件接入下载
			if(fileDirType.equals(Constant.LOCAL_DIR)){
				File srcDirF = new File(fileDir);
				localTypeFileDownload(fileMap,fileList,fileSortType,moveFileInfos,fileNum,srcDirF,srcDirF,filterExpression,fileTempDir);
				response.append(" ").append("#").append(new java.sql.Timestamp(System.currentTimeMillis()).toString())
				.append("#  local download from").append(srcDirF.getAbsoluteFile()).append(" to").append(fileTempDir);
			//远程文件接入下载
			}else{
				fileArray = remoteFileDownload(endpoint,response,fileMap,fileList,moveFileInfos,fileNum,fileSortType,fileDir,filterExpression,fileTempDir,msg,tempDir);
			}
			//文件对象信息
			msg.setTempFileDirName(fileTempDir);
			endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_SUCCESS);
			
			if(fileArray == null) {
				
				fileArray = (File[])fileList.toArray(new File[fileList.size()]);
			}
			
			msg.setMsgBody(fileArray);
			msg.setSuccessNum(fileArray.length);
			msg.setFailNum(0);
			msg.setMessageMap(new Hashtable<String,String>());
			response.append(" success num:").append(fileArray.length);
			msg.setResponseDes(msg.getResponseDes()+response.toString());
			msg.setInputFileNum(fileArray.length);
			if(logger.isInfoEnabled()){
				logger.info("#DownloadProcessor END# SerInvokeInsName:{0} ,curryEndpointId:{1},download file num:{2}",msg.getSerInvokeIns().getSerInvokeInsName(),endpoint.getEndpointId(),fileArray.length);
			}
		}catch (BusinessException e) {
			makeExceptionInfo(endpoint, msg, response, fileMap, fileList);
			logger.error("#DownloadProcessor#",new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"DownloadProcessor endpoint="+endpoint.getEndpointId(),e.getResult().toString()}, e));
			throw new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"DownloadProcessor  endpoint="+endpoint.getEndpointId(),e.getResult().toString()}, e);
		}catch(Exception e){
			makeExceptionInfo(endpoint, msg, response, fileMap, fileList);
			logger.error("#DownloadProcessor#",new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"DownloadProcessor  endpoint="+endpoint.getEndpointId(),e.getMessage()}, e));
			throw new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"DownloadProcessor  endpoint="+endpoint.getEndpointId(),e.getMessage()}, e);
		}
		return msg;
	}
	
	private File[] remoteFileDownload(Endpoint endpoint, StringBuffer response, Map<String, String> fileMap, List<File> fileList, List<ExtAttr> moveFileInfos, int fileNum, 
			String fileSortType, String fileDir, String filterExpression, String fileTempDir, MessageBO msg, File tempDir) throws Exception {
		Object obj = endpoint.getAttrMap().get(EndpointAttr.ServiceTechId);
		TechImpl tech = null;
		File[] fileArray = null;
		if(obj==null){
			throw new BusinessException(9066, "o2p-serviceagent-core.9066", new String[]{"EndpointAttr="+EndpointAttr.ServiceTechId}, null);
		}else{
			String serTechId = obj.toString();
			tech = (TechImpl) cacheService.getKey(CacheKey.techImpl + serTechId, msg.getTenant().getTenantId());
			if(tech==null){
				throw new BusinessException(9067, "o2p-serviceagent-core.9067", new String[]{"serTechId="+serTechId}, null);
			}
			if(!tech.getSerTechStatus().equals(EOPDomain.ONLINE)){
				throw new BusinessException(9069,"o2p-serviceagent-core.9069", new String[]{"techImplId="+tech.getTechImplId()+", online state="+EOPDomain.ONLINE}, null);
			}
			
			String isScanSubDirStr = Constant.NO;
			Object isScanSubDir = endpoint.getAttrMap().get(Constant.FILE_SCAN_SUB_DIR);
			if(logger.isDebugEnabled()) {
				
				logger.debug("=========> endpoint.getAttrMap():"+endpoint.getAttrMap().toString());
			}
			if(isScanSubDir != null && !"".equals(isScanSubDir.toString().trim())) {
				
				isScanSubDirStr = isScanSubDir.toString();
			}
			
			//ftp接入下载
			if(tech.getCommProCd().toString().equalsIgnoreCase(EOPDomain.FTP_PROTOCOL)){
				FtpTypeFileDownload(response,fileMap,fileList,moveFileInfos,fileNum,fileSortType,tech,fileDir,filterExpression,fileTempDir, isScanSubDirStr);
				return null;
			//sftp接入下载
			}else if(tech.getCommProCd().toString().equalsIgnoreCase(EOPDomain.SFTP_PROTOCOL)){
				SftpTypeFileDownload(response,fileMap,fileList,moveFileInfos,fileNum,fileSortType,tech,fileDir,filterExpression,fileTempDir, isScanSubDirStr);
				return null;
				//http接入下载	
			}else if(EOPDomain.HTTP_POST_PROTOCOL.equalsIgnoreCase(tech.getCommProCd())
					|| EOPDomain.HTTP_GET_PROTOCOL.equalsIgnoreCase(tech.getCommProCd())){
				
				httpTypeFileDownload(msg,response,tech,fileTempDir,moveFileInfos);
				fileArray = tempDir.listFiles();
				return fileArray;
			}
			return null;
		}
	}

	private void httpTypeFileDownload(MessageBO msg, StringBuffer response, TechImpl tech, String fileTempDir, List<ExtAttr> moveFileInfos) throws OgnlException {

		HttpSession http = new HttpSession();
		
		response
		.append("#")
		.append(new java.sql.Timestamp(System.currentTimeMillis()).toString())
		.append("# down HTTP to ")
		.append(fileTempDir);
		
		String url = getHttpUrl(tech,msg);
		http.httpDownload(new HttpClient(), url, fileTempDir,moveFileInfos,tech);

	}
	
	private String getHttpUrl(TechImpl tech, MessageBO msg) throws OgnlException {

		Map urlMap = tech.getAttrMap();
		if(urlMap == null){
			
			throw new BusinessException(9070, "o2p-serviceagent-core.9070", new String[]{"techImplId="+tech.getTechImplId()}, null);
		}else{
			String url = (String)urlMap.get(EndpointAttr.ADDRESS);
			StringBuffer sb = new StringBuffer();
			String[] sUrl = url.split("\\{");
			for(String u : sUrl) {
				
				if(u.contains("}")) {
					
					String[] ssUrl = u.split("\\}");
					String express = ssUrl[0];
					String value = getValue(express, msg);
					sb.append(value);
					sb.append(ssUrl[1]);
				} else {
					
					sb.append(u);
				}
				
				
			}
			return sb.toString();
		}
		
	}
	
	private String getValue(String express, MessageBO msg) throws OgnlException {
		
		if(StringUtils.hasText(express)) {
			
			if(express.contains("sysdate")) {
				
				String format = express.split("\\'")[1];
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				String dateStr = sdf.format(new Date());
				
				return dateStr;
			} else {
				
				OgnlContext context = new OgnlContext();

				context.put("messageBO", msg);
				
				Object obj = Ognl.getValue(express, msg);
				
				if(logger.isDebugEnabled()) {
					
					logger.debug("http download ognl express:"+express+", value:"+obj.toString());
				}
				
				return obj.toString();
			}
		}
	
		return null;
	}
	
	private void makeExceptionInfo(Endpoint endpoint, MessageBO msg,
			StringBuffer response, Map<String, String> fileMap,
			List<File> fileList) {
		File[] fileArray = (File[])fileList.toArray(new File[fileList.size()]);
		msg.setMsgBody(fileArray);
		msg.setMessageMap(fileMap);
		endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_FAIL);
		response.append(" success num:").append(fileArray.length).append(" fail num:").append(fileMap.size());
		msg.setResponseDes(msg.getResponseDes()+response.toString());
		msg.setFailNum(fileMap.size());
		StringBuffer sb = new StringBuffer();
		for(String key:fileMap.keySet()){
			sb.append(key).append(",");
			msg.setFailMsg(sb.toString());
		}
		msg.setSuccessNum(fileArray.length);
		msg.setInputFileNum(fileArray.length);
	}
	

	public void SftpTypeFileDownload(StringBuffer response,Map<String,String> fileMap,List<File> fileList,List<ExtAttr> moveFileInfos, Integer fileNum,String fileSortType,TechImpl tech,String fileDir,String filterExpression,String fileTempDir, String isScanSubDirStr) throws Exception{
		if(logger.isDebugEnabled()) {
			logger.debug(" SFTP Type");
		}
		String pwd = tech.getAttrMap().get(EndpointAttr.SFTP_PASSWORD);
		String url = tech.getAttrMap().get(EndpointAttr.SFTP_SERVERIP);
		String userName = tech.getAttrMap().get(EndpointAttr.SFTP_USERNAME);
		Integer port = Integer.valueOf(tech.getAttrMap().get(EndpointAttr.SFTP_PORT));
		String authFilePath = tech.getAttrMap().get(EndpointAttr.SFTP_AUTH_FILE_PATH);
		String passphrase = tech.getAttrMap().get(EndpointAttr.SFTP_PASSPHRASE);
		if(logger.isDebugEnabled()) {
			logger.debug(" SFTP : ip= {0} ,port={1},suerName = {2},fileDir={3}",url,port,userName,fileDir);
		}
		
		response
		.append("#")
		.append(new java.sql.Timestamp(System.currentTimeMillis()).toString())
		.append("# SFTP account:")
		.append(userName)
		.append(" ip:")
		.append(url)
		.append(" download from ")
		.append(fileDir)
		.append(" to")
		.append(fileTempDir);
		

		DefaultSftpSessionFactory sftpFac = new DefaultSftpSessionFactory();
		sftpFac.setHost(url);
		sftpFac.setUser(userName);
		sftpFac.setPort(port);
		
		Object timeObj = tech.getAttrMap().get(EndpointAttr.TIMEOUT);
		if(timeObj!=null){
			if(StringUtils.hasText(timeObj.toString())) {
				int timeOut = Integer.valueOf(timeObj.toString());
				sftpFac.setTimeout(timeOut*1000);
			}
		}
		if(StringUtils.hasText(authFilePath)){
			Resource privateKey = new FileSystemResource(authFilePath);
			sftpFac.setPrivateKey(privateKey);
			sftpFac.setPrivateKeyPassphrase(passphrase);	
		}else{
			sftpFac.setPassword(decryMsg(pwd));
		}
		Session<LsEntry,ChannelSftp> session = null;
		try{
			session = sftpFac.getSession();
			if(StringUtils.hasText(filterExpression)){
				session.downloadFromDir(fileMap,fileList,fileSortType,moveFileInfos,fileNum,fileDir,fileTempDir,filterExpression, "",new DownloadCallBack<ChannelSftp>() {
					public void doFile(ChannelSftp client, String fileName, String path) {
						try {
							client.rm(fileName);
						} catch (SftpException e) {
							logger.error(LogModel.EVENT_APP_EXCPT,new BusinessException(9251, "9251.SUBPUB.DELETE.ERROR",new String[]{"SFTP",fileName}, e));
						}
					}
				},isScanSubDirStr);
			}else{
				session.downloadFromDir(fileMap,fileList,fileSortType,moveFileInfos,fileNum,fileDir,fileTempDir, "",new DownloadCallBack<ChannelSftp>() {
					public void doFile(ChannelSftp client, String fileName, String path) {
						try {
							client.rm(fileName);
						} catch (SftpException e) {
							logger.error(LogModel.EVENT_APP_EXCPT,new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR",new String[]{"SFTP",fileName}, e));
						}
					}
				},isScanSubDirStr);
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
	
	private void FtpTypeFileDownload(StringBuffer response,Map<String, String> fileMap,List<File> fileList,List<ExtAttr> moveFileInfos, Integer fileNum,String fileSortType,TechImpl tech,String fileDir,String filterExpression,String fileTempDir, String isScanSubDirStr) throws Exception{
		if(logger.isDebugEnabled()) {
			logger.debug(" FTP Type");
		}
		String pwd = tech.getAttrMap().get(EndpointAttr.FTP_PASSWORD);
		String url = tech.getAttrMap().get(EndpointAttr.FTP_SERVERIP);
		String userName = tech.getAttrMap().get(EndpointAttr.FTP_USERNAME);
		Integer port = Integer.valueOf(tech.getAttrMap().get(EndpointAttr.FTP_PORT));
		if(logger.isDebugEnabled()) {
			logger.debug(" FTP : ip= {0} ,port={1},fileDir={2}",url,port,fileDir);
		}
		
		response
		.append("#")
		.append(new java.sql.Timestamp(System.currentTimeMillis()).toString())
		.append("# FTP account:")
		.append(userName)
		.append(" ip:")
		.append(url)
		.append(" download from ")
		.append(fileDir)
		.append(" to")
		.append(fileTempDir);
		
		DefaultFtpSessionFactory ftpSessionFac = new DefaultFtpSessionFactory();
		ftpSessionFac.setHost(url);
		ftpSessionFac.setPort(port);
		ftpSessionFac.setUsername(userName);
		ftpSessionFac.setPassword(decryMsg(pwd));
		Session<FTPFile,FTPClient> session = null;
		try{
			session = ftpSessionFac.getSession();
			if(StringUtils.hasText(filterExpression)){
				session.downloadFromDir(fileMap,fileList,fileSortType,moveFileInfos,fileNum,fileDir,fileTempDir,filterExpression,"",new DownloadCallBack<FTPClient>() {
					public void doFile(FTPClient client, String fileName, String path) {
							try {
								client.deleteFile(fileName);
							} catch (IOException e) {
								throw new BusinessException(9251, "9251.SUBPUB.DELETE.ERROR",new String[]{"FTP",fileName}, e);
							}
					}
				},isScanSubDirStr);
			}else{
				session.downloadFromDir(fileMap,fileList,fileSortType,moveFileInfos,fileNum,fileDir,fileTempDir,"",new DownloadCallBack<FTPClient>() {
					public void doFile(FTPClient client, String fileName, String path) {
							try {
								client.deleteFile(fileName);
							} catch (IOException e) {
								throw new BusinessException(9251, "SUBPUB.FILEDIR.ERROR",new String[]{"FTP",fileName}, e);
							}
					}
				},isScanSubDirStr);
			}
		}catch(Exception e){
			throw e ;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
	
	private void localTypeFileDownload(Map<String,String> fileMap,List<File> fileList,String fileSortType,List<ExtAttr> moveFileInfos, Integer fileNum,File srcDirF,File dir,String filterExpression,String fileTempDir) throws IOException{
		if(logger.isDebugEnabled()) {
			logger.debug(" local Type ,srcDirF={0}",srcDirF);
		}
		
		filterExpression = FileFilterExpression.validateExpression(filterExpression);
		final String filter = filterExpression;
		
		if(srcDirF.listFiles()!=null && srcDirF.listFiles().length>0){
			File[] locSrcArray = srcDirF.listFiles();
			
			//文件排序
			File[] locSrcs = new File[locSrcArray.length];
			if(fileSortType.equals(EOPDomain.ORDERBY_LENGTH_DESC)){
				 locSrcs =FileSortUtil.orderByLengthDesc(locSrcArray);
			}else if(fileSortType.equals(EOPDomain.ORDERBY_LENGTH_ASC)){
				 locSrcs =FileSortUtil.orderByLengthAsc(locSrcArray);
			}else if(fileSortType.equals(EOPDomain.ORDERBY_NAME_ASC)){
				 locSrcs =FileSortUtil.orderByNameAsc(locSrcArray);
			}else if(fileSortType.equals(EOPDomain.ORDERBY_NAME_DESC)){
				 locSrcs =FileSortUtil.orderByNameDesc(locSrcArray);
			}else if(fileSortType.equals(EOPDomain.ORDERBY_FILE_TYPE_ASC)){
				 locSrcs =FileSortUtil.orderByFileTypeAsc(locSrcArray);
			}else if(fileSortType.equals(EOPDomain.ORDERBY_FILE_TYPE_DESC)){
				 locSrcs =FileSortUtil.orderByFileTypeDesc(locSrcArray);
			}else if(fileSortType.equals(EOPDomain.ORDERBY_MODIFY_DATE_ASC)){
				 locSrcs =FileSortUtil.orderByDateAsc(locSrcArray);
			}else if(fileSortType.equals(EOPDomain.ORDERBY_MODIFY_DATE_DESC)){
				 locSrcs =FileSortUtil.orderByDateDesc(locSrcArray);
			}else{
				locSrcs = srcDirF.listFiles();
			}
			
			
			for(int i=0;i<locSrcs.length;i++){
				if(fileList.size()+fileMap.size()==fileNum){
					break;
				}
				
				//优先执行未处理完成的.ing文件
				Iterator<Entry<String, String>> itor = fileMap.entrySet().iterator();
				while(itor.hasNext()){
					
					Entry<String, String> e = itor.next(); 
					String key = e.getKey();
					File lostIngFile = new File(e.getValue());
					
					String directory = lostIngFile.getParent().replace(dir.getAbsolutePath(), "");
					
					File tempDir = new File(fileTempDir+"/"+directory);
					FileUtils.moveFileToDirectory(lostIngFile, tempDir,true);
					
					File locingFile = new File(tempDir.getAbsolutePath()+"/"+lostIngFile.getName());
					String locFileName = tempDir.getAbsolutePath()+"/"+key;
					File locFile = new File(locFileName);
					
					if(locingFile.renameTo(locFile)){
						fileList.add(locFile);
						//删除已经下载到临时目录的文件记录
						fileMap.remove(key);
					}
				}
				
				File loc = locSrcs[i];
				if(loc.isFile()){
					if(!loc.getName().endsWith(".ing") && FileFilterExpression.validateFileName(loc.getName(), filter)){
						File ingFile = new File(loc.getAbsoluteFile()+".ing");
						if(loc.renameTo(ingFile)){
							//记录转成ing的文件
							fileMap.put(loc.getName(), ingFile.getAbsolutePath());
						}
						String directory = loc.getParent().replace(srcDirF.getAbsolutePath(), "");
						
						File tempDir = new File(fileTempDir+"/"+directory);
						FileUtils.moveFileToDirectory(ingFile, tempDir,true);
						
						File locingFile = new File(tempDir.getAbsolutePath()+"/"+ingFile.getName());
						String locFileName = tempDir.getAbsolutePath()+"/"+loc.getName();
						File locFile = new File(locFileName);
						if(locingFile.renameTo(locFile)){
							fileList.add(locFile);
							//删除已经下载到临时目录的文件记录
							fileMap.remove(loc.getName());
						}
					}
				}else{
					localTypeFileDownload(fileMap,fileList,fileSortType,moveFileInfos,fileNum,loc,srcDirF,filterExpression,fileTempDir);
				}
			}
		}
	}
	
	private Map<String,String> endpointValue(Endpoint endpoint,SerInvokeIns serInvokeIns){
		
		Map<String,String> map = new HashMap<String,String>();
		
		Object fileDirTypeObj = endpoint.getAttrMap().get(EndpointAttr.FILE_DIR_TYPE);
		String fileDirType = "R";
		if(fileDirTypeObj!=null && !StringUtil.isBlank(fileDirTypeObj.toString())){
			fileDirType = fileDirTypeObj.toString();
		}
		map.put(EndpointAttr.FILE_DIR_TYPE, fileDirType);
		
		Object fileSortTypeObj = endpoint.getAttrMap().get(EndpointAttr.FILE_SORT_TYPE);
		String fileSortType = EOPDomain.ORDERBY_NO;
		if(fileSortTypeObj!=null && !StringUtil.isBlank(fileSortTypeObj.toString())){
			fileSortType = fileSortTypeObj.toString();
		}
		map.put(EndpointAttr.FILE_SORT_TYPE, fileSortType);
		
		Object fileDirObject = endpoint.getAttrMap().get(EndpointAttr.LINK_FILE_DIR);
		String fileDir = "";
		if(fileDirObject != null && !org.apache.commons.lang.StringUtils.isEmpty(fileDirObject.toString())) { 
			
			fileDir = fileDirObject.toString();
			//替换动态目录路径
			fileDir = Constant.replacePath(fileDir);
		} else {

//			throw new BusinessException(9556,"9556.SUBPUB.FILEDIR.ERROR", new String[]{"fileDir="+fileDir}, null);
		}
		
		map.put(EndpointAttr.LINK_FILE_DIR,fileDir);
		
		String fileNum = "10";
		Object limitNum= endpoint.getAttrMap().get(EndpointAttr.FILE_DOWNLOAD_LIMIT_NUM);
		if(limitNum!=null && !"".equals(limitNum.toString())){
			fileNum =limitNum.toString();
		}
		map.put(EndpointAttr.FILE_DOWNLOAD_LIMIT_NUM,fileNum);
		
		String userPath = FileUtils.getUserDirectoryPath()+File.separator+"tempfile";
		if(!StringUtil.isBlank(downloadTempDir)){
			userPath = downloadTempDir+File.separator+"tempfile";
		}
		
		String fileTempDir = "";
		Object fileTempDirObj = endpoint.getAttrMap().get(EndpointAttr.FILE_TEMP_DIR);
		if(fileTempDirObj!=null && !"".equals(fileTempDirObj)){
			
			fileTempDir =(String)fileTempDirObj+File.separator+"upload"+File.separator;
		}else{
			fileTempDir = userPath+File.separator+serInvokeIns.getSerInvokeInsId()+File.separator+"upload"+File.separator;
		}
		map.put(EndpointAttr.FILE_TEMP_DIR,fileTempDir);
		
		Object messageRuleObj = endpoint.getAttrMap().get(EndpointAttr.MESSAGE_RULE);
		String filterExpression =null;
		if(messageRuleObj!=null){
			filterExpression = (String)messageRuleObj;
		}
		map.put(EndpointAttr.MESSAGE_RULE,filterExpression);
		
		return map;
	}
	

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public void subtraThreadNum(String servId) throws EAAPException {
		// TODO Auto-generated method stub
		
	}
	public IMemcacheManageServ getCacheService() {
		return cacheService;
	}

	public void setCacheService(IMemcacheManageServ cacheService) {
		this.cacheService = cacheService;
	}

	public String getDownloadTempDir() {
		return downloadTempDir;
	}

	public void setDownloadTempDir(String downloadTempDir) {
		this.downloadTempDir = downloadTempDir;
	}
}
