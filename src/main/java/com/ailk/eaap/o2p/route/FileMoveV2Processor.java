/** 
 * Project Name:o2p-subpub-service 
 * File Name:FileMoveV2Processor.java 
 * Package Name:com.ailk.eaap.o2p.route 
 * Date:2014年9月29日下午3:54:10 
 * Copyright (c) 2014, www.asiainfo.com All Rights Reserved. 
 * 
 */

package com.ailk.eaap.o2p.route;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
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

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.ailk.eaap.o2p.common.Constant;
import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.o2p.common.security.SecurityUtil;
import com.ailk.eaap.o2p.util.file.remote.session.Session;
import com.ailk.eaap.o2p.util.file.remote.session.ftp.DefaultFtpSessionFactory;
import com.ailk.eaap.o2p.util.file.remote.session.sftp.DefaultSftpSessionFactory;
import com.ailk.eaap.op2.common.EAAPException;
import com.ailk.eaap.op2.serviceagent.common.EOPDomain;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.route.service.EndpointProcessor;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.Endpoint;
import com.ailk.eaap.op2.bo.EndpointAttr;
import com.ailk.eaap.op2.bo.SerInvokeIns;
import com.ailk.eaap.op2.bo.TechImpl;
import com.asiainfo.integretion.o2p.serviceagent.cache.IMemcacheManageServ;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.linkage.rainbow.util.StringUtil;

public class FileMoveV2Processor implements EndpointProcessor {

	private final static Logger logger = Logger.getLog(FileMoveV2Processor.class);
	private IMemcacheManageServ cacheService;
	private String backupTempDir;
	
	public MessageBO process(Endpoint endpoint, MessageBO msg)
			throws EAAPException {
		if(logger.isInfoEnabled()) {
			logger.info("#FileMoveV2Processor START# SerInvokeInsName:{0} ,curryEndpointId:{1}",msg.getSerInvokeIns().getSerInvokeInsName(),endpoint.getEndpointId());
		}
		StringBuffer response = new StringBuffer();
		response.append(" <ENDPOINTID=").append(endpoint.getEndpointId()).append(">");
		File[] fileArray = null;
		Map<String, File> oldFileMap = new ConcurrentHashMap<String, File>();
		File[] files = null;
		List<File> list = new ArrayList<File>();
		try {
			 if(msg.getMsgBody() instanceof File[]){
				 fileArray = (File[])msg.getMsgBody();
			}else {
				if(logger.isDebugEnabled()) {
					logger.debug("fileArray is null!");
				}
				return msg;
			}
			if(fileArray==null || fileArray.length<=0){
				 if(logger.isDebugEnabled()) {
					 logger.debug("fileArray is null");
				 }
				 return msg;
			}
			SerInvokeIns serInvokeIns = msg.getSerInvokeIns();
			Map<String,String> vmap = endpointValue(endpoint, serInvokeIns);
			String postAction = vmap.get(EndpointAttr.ATTR_SPEC_CODE_POST_READ_ACTION);
			String fileBackupDir = vmap.get(EndpointAttr.BACKUP_FILE_DIR);
			String fileFormats = vmap.get(EndpointAttr.FILE_FORMATS);
			String fileTagerDir = vmap.get(EndpointAttr.LINK_FILE_DIR);
			String fileDirType = vmap.get(EndpointAttr.FILE_DIR_TYPE);
			//动态目录pattern
			String dirDatePattern=vmap.get(EndpointAttr.DIR_DATE_PATTERN);
			if(logger.isDebugEnabled()) {
				logger.debug("fileDirType:{0},fileTagerDir:{1},fileFormats:{2},fileBackupDir:{3},postAction:{4}",fileDirType,fileTagerDir,fileFormats,fileBackupDir,postAction);
			}
			File tempDir = new File(fileBackupDir);
			if (!tempDir.exists()){
				FileUtils.forceMkdir(tempDir);
			}
			Map<String, File> fileMap = new ConcurrentHashMap<String, File>();
			for(int i=0;i<fileArray.length;i++){
				File f = fileArray[i];
				String oldFileName = f.getName();
				String newFileName = getFileName(oldFileName,fileFormats);
				File newFile = new File(f.getParent()+File.separator+newFileName);
				if(f.renameTo(newFile)){
					fileMap.put(newFile.getAbsolutePath(), newFile);
					oldFileMap.put(f.getAbsolutePath(), newFile);
				}
			}
			if(fileMap.size()<1){
				if(logger.isDebugEnabled()) {
					logger.debug("endpoint: {0} fileMap is null",endpoint.getEndpointId());
				}
				return msg;	
			}
			if(logger.isDebugEnabled()) {
				logger.debug("endpoint: {0} fileMap:{1} ",endpoint.getEndpointId(),fileMap);
			}
			if(fileDirType.equals(Constant.LOCAL_DIR)){
				localTypeFileDownload(list,fileMap,oldFileMap, msg, fileTagerDir, dirDatePattern,fileBackupDir,postAction);
				response.append("#").append(new java.sql.Timestamp(System.currentTimeMillis()).toString()).append("# local move from ").append(msg.getTempFileDirName()).append(" to").append(fileTagerDir);
			}else{
				Object obj = endpoint.getAttrMap().get(EndpointAttr.ServiceTechId);
				TechImpl tech = null;
				if (obj == null) {
					throw new BusinessException(9066, "o2p-serviceagent-core.9066", new String[]{"EndpointAttr="+EndpointAttr.ServiceTechId}, null);
				} else {
					String serTechId = obj.toString();
					tech = (TechImpl) cacheService.getKey(CacheKey.techImpl + serTechId, msg.getTenant().getTenantId());
					if(tech==null){
						throw new BusinessException(9067, "o2p-serviceagent-core.9067", new String[]{"serTechId="+serTechId}, null);
					}
					if(!tech.getSerTechStatus().equals(EOPDomain.ONLINE)){
						throw new BusinessException(9069,"o2p-serviceagent-core.9069", new String[]{"techImplId="+tech.getTechImplId()+", online state="+EOPDomain.ONLINE}, null);
					}
					//ftp上传
					if(tech.getCommProCd().toString().equalsIgnoreCase(EOPDomain.FTP_PROTOCOL)){
						uploadFtpType(response,list,tech,fileMap,oldFileMap, msg, fileTagerDir,dirDatePattern, fileBackupDir,postAction);
					//sftp上传
					}else if (tech.getCommProCd().toString().equalsIgnoreCase(EOPDomain.SFTP_PROTOCOL)){
						uploadSftpType(response,list,tech,fileMap, oldFileMap,msg, fileTagerDir, dirDatePattern,fileBackupDir,postAction);
					}
				}
			}
			makeSuccessInfo(endpoint, msg, response, fileArray, list,fileTagerDir);
		}catch (BusinessException e) {
			makeExceptionInfo(endpoint, msg, response, oldFileMap, list);
			logger.error("#FileMoveV2Processor#",new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FileMoveV2Processor endpoint="+endpoint.getEndpointId(),e.getResult().toString()}, e));
			throw new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FileMoveV2Processor endpoint="+endpoint.getEndpointId(),e.getResult().toString()}, e);
		} catch (Exception e) {
			makeExceptionInfo(endpoint, msg, response, oldFileMap, list);
			logger.error("#FileMoveV2Processor#",new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FileMoveV2Processor  endpoint="+endpoint.getEndpointId(),e.getMessage()}, e));
			throw new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FileMoveV2Processor endpoint="+endpoint.getEndpointId(),e.getMessage()}, e);
		}
		return msg;
	}

	private void makeSuccessInfo(Endpoint endpoint, MessageBO msg,
			StringBuffer response, File[] fileArray, List<File> list,
			String fileTagerDir) {
		File[] files;
		files = (File[])list.toArray(new File[list.size()]);
		msg.setMsgBody(files);
		msg.setTempFileDirName(fileTagerDir);
		msg.setMessageMap(new Hashtable<String,String>());
		endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_SUCCESS);
		response.append(" success num:").append(files.length);
		msg.setResponseDes(msg.getResponseDes()+response.toString());
		msg.setSuccessNum(files.length);
		msg.setFailNum(0);
		msg.setOutputErrFileNum(0);
		msg.setOutputSuccessFileNum(fileArray.length);
		if(logger.isInfoEnabled()) {
			logger.info("#FileMoveV2Processor END# SerInvokeInsName:{0} ,curryEndpointId:{1},move file num:{2} ",msg.getSerInvokeIns().getSerInvokeInsName(),endpoint.getEndpointId(),files.length);
		}
	}

	private void makeExceptionInfo(Endpoint endpoint, MessageBO msg,
			StringBuffer response, Map<String, File> oldFileMap, List<File> list) {
		msg.setMsgBody(exceptionOldFileRename(oldFileMap));
		endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_FAIL);
		response.append(" success num:").append(list.size()).append(" fail num:").append(oldFileMap.size());
		msg.setResponseDes(msg.getResponseDes()+response.toString());
		msg.setSuccessNum(list.size());
		StringBuffer sb = new StringBuffer();
		for(Object key:oldFileMap.keySet()){
			sb.append(key).append(",");
			msg.setFailMsg(sb.toString());
		}
		msg.setFailNum(oldFileMap.size());
		
		msg.setOutputErrFileNum(oldFileMap.size());
		msg.setOutputSuccessFileNum(msg.getMessageMap().size());
	}
	
	private String decryMsg(String msg) {
		return SecurityUtil.getInstance().decryMsg(msg);
	}
	
	/**
	 * FTP文件上传
	 * @param tech
	 * @param fileMap
	 * @param tempFileDirName
	 * @param fileTagerDir
	 * @param fileBackupDir
	 * @param postAction
	 * @return
	 */
	@SuppressWarnings("finally")
	private void uploadFtpType(StringBuffer response,List<File> list,TechImpl tech,Map<String, File> fileMap,Map<String, File>oldFileMap,MessageBO msg,String fileTagerDir,String dirDatePattern,String fileBackupDir,String postAction) {
		if(logger.isDebugEnabled()) {
			logger.debug(" FTP Type");
		}
		String pwd = tech.getAttrMap().get(EndpointAttr.FTP_PASSWORD);
		String url = tech.getAttrMap().get(EndpointAttr.FTP_SERVERIP);
		String userName = tech.getAttrMap().get(EndpointAttr.FTP_USERNAME);
		Integer port = Integer.valueOf(tech.getAttrMap().get(EndpointAttr.FTP_PORT));
		if(logger.isDebugEnabled()) {
			logger.debug(" FTP : ip= {0} ,port={1},fileTagerDir={2}",url,port,fileTagerDir);
		}
		
		response
		.append("#")
		.append(new java.sql.Timestamp(System.currentTimeMillis()).toString())
		.append("# FTP account:")
		.append(userName)
		.append(" ip:")
		.append(url)
		.append(" move from ")
		.append(msg.getTempFileDirName())
		.append(" to")
		.append(fileTagerDir);
		
		DefaultFtpSessionFactory ftpSessionFac = new DefaultFtpSessionFactory();
		ftpSessionFac.setHost(url);
		ftpSessionFac.setPort(port);
		ftpSessionFac.setUsername(userName);
		ftpSessionFac.setPassword(decryMsg(pwd));
		Session<FTPFile, FTPClient> session = null;
		try{
			
			session = ftpSessionFac.getSession();
			uploadFile(list,fileMap,oldFileMap,session,msg,fileTagerDir,dirDatePattern,fileBackupDir,postAction);
			
		}catch(Exception e){
			throw new BusinessException(9553,"9553.SUBPUB.MOVE",null, e);
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
	
	/**
	 * SFTP文件上传
	 * @param tech
	 * @param fileMap
	 * @param tempFileDirName
	 * @param fileTagerDir
	 * @param fileBackupDir
	 * @param postAction
	 * @return
	 */
	@SuppressWarnings("finally")
	private void uploadSftpType(StringBuffer response,List<File> list,TechImpl tech,Map<String, File> fileMap,Map<String, File>oldFileMap,MessageBO msg,String fileTagerDir,String dirDatePattern,String fileBackupDir,String postAction){
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
			logger.debug(" SFTP : ip= {0} ,port={1},fileTagerDir={2}",url,port,fileTagerDir);
		}
		
		response
		.append("#")
		.append(new java.sql.Timestamp(System.currentTimeMillis()).toString())
		.append("# SFTP account:")
		.append(userName)
		.append(" ip:")
		.append(url)
		.append(" move from ")
		.append(msg.getTempFileDirName())
		.append(" to ")
		.append(fileTagerDir);
		
		DefaultSftpSessionFactory sftpFac = new DefaultSftpSessionFactory();
		sftpFac.setHost(url);
		sftpFac.setUser(userName);
		sftpFac.setPort(port);
		if(StringUtils.hasText(authFilePath)){
			Resource privateKey = new FileSystemResource(authFilePath);
			sftpFac.setPrivateKey(privateKey);
			sftpFac.setPrivateKeyPassphrase(passphrase);	
		}else{
			sftpFac.setPassword(decryMsg(pwd));
		}
		
		Session<LsEntry, ChannelSftp> session = null;
		try{
			session = sftpFac.getSession();
			uploadFile(list,fileMap,oldFileMap,session,msg,fileTagerDir,dirDatePattern,fileBackupDir,postAction);
		}catch(Exception e){
			throw new BusinessException(9553,"9553.SUBPUB.MOVE",null, e);
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
	
	/**
	 * 本地文件搬迁
	 * @param fileMap
	 * @param tempFileDirName
	 * @param fileTagerDir
	 * @param fileBackupDir
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("finally")
	private void localTypeFileDownload(List<File> fileList,Map<String, File> fileMap,Map<String, File>oldFileMap,MessageBO msg,String fileTagerDir,String dirDatePattern,String fileBackupDir,String postAction) throws IOException{
		if(logger.isDebugEnabled()) {
			logger.debug(" local Type");
		}
			
		uploadFile(fileList, fileMap,oldFileMap,null,msg,fileTagerDir,dirDatePattern, fileBackupDir,postAction);
		
	}
	
	
	/**
	 * 文件上传操作
	 * @param fileMap
	 * @param session
	 * @param tempFileDirName
	 * @param fileTagerDir
	 * @param fileBackupDir
	 * @return
	 */
	private void uploadFile(List<File> list,Map<String,File> fileMap,Map<String, File>oldFileMap,Session session,MessageBO msg,String fileTagerDir,String dirDatePattern,String fileBackupDir,String postAction) {
		
		String tempFileDirName = msg.getTempFileDirName();
		SimpleDateFormat sdf;
		String defaultDirDatePattern="yyyy-MM-dd";
		try {
			sdf = new SimpleDateFormat(dirDatePattern);
		} catch (NullPointerException nullPointerException) {
			logger.warn("#uploadFile#", new BusinessException(9558,"9558.SUBPUB.FILEDATEPATTERN.ERROR",new String[]{dirDatePattern},nullPointerException));
			sdf = new SimpleDateFormat(defaultDirDatePattern);
		}catch (IllegalArgumentException illegalArgumentException) {
			logger.warn("#uploadFile#", new BusinessException(9558,"9558.SUBPUB.FILEDATEPATTERN.ERROR",new String[]{dirDatePattern},illegalArgumentException));
			sdf = new SimpleDateFormat(defaultDirDatePattern);
		}
		//记录以及搬迁成功的文件信息
		Map<String,String> finishFileMap = msg.getMessageMap();
		File tempFileDir = new File(tempFileDirName);
		if(finishFileMap!=null){
			Iterator<Entry<String, String>> itor = finishFileMap.entrySet().iterator();     
		    while(itor.hasNext()){   
		    	Entry<String, String> e = itor.next(); 
				list.add(new File(e.getValue()));
			}
		}else{
			finishFileMap = new ConcurrentHashMap<String, String>(); 
		}
		//请求落地方时间
		if(msg.getSourceContractInteraction().getCenterFwd2DstTime() == null) {
			msg.getSourceContractInteraction().setCenterFwd2DstTime(new Timestamp(System.currentTimeMillis()));
			msg.getSourceContractInteraction().setDstRecTime(new Timestamp(System.currentTimeMillis()));
		}
		Iterator<Entry<String, File>> itor = fileMap.entrySet().iterator();
		while(itor.hasNext()){
			Entry<String, File> en = itor.next();
			String key = en.getKey();
			File file = en.getValue();
			if(file!=null){
				try {
					if(logger.isDebugEnabled()) {
						logger.debug("---NO:1--- deal file: {0}, directory: {1}",file.getAbsolutePath(),fileTagerDir);
					}
					String hierarchy = (file.getParent()+File.separator).replace(tempFileDir.getAbsolutePath(),"");
					//加入动态目录
					java.util.Date date=new java.util.Date(file.lastModified());
					String  directoryH = fileTagerDir+"/"+sdf.format(date)+hierarchy.replace("\\", "/");
					if(dirDatePattern==null||"".equals(dirDatePattern)){
						directoryH=fileTagerDir+hierarchy.replace("\\", "/");
					}
					if(logger.isDebugEnabled()) {
						logger.debug("---NO:2---  file.getName : {0}, directoryH :{1}, hierarchy :{2},filesize={3}",file.getName(),directoryH,hierarchy,file.length());
					}
					
					if(session!=null){
						session.upload(directoryH, file.getAbsolutePath());
					}else{
						FileUtils.copyFileToDirectory(file, new File(directoryH));
					}
					//搬迁后处理
					if(postAction.equals(Constant.POST_ACTION_ARCHIVE_AND_DEL)){
						File archiveDir = new File(fileBackupDir+"/"+hierarchy);
						if(!archiveDir.exists()){
							FileUtils.forceMkdir(archiveDir);
						}
						if(file.exists()) {
							if(file.isDirectory()) {
								FileUtils.copyDirectoryToDirectory(file, archiveDir);
							} else {
								FileUtils.copyFileToDirectory(file, archiveDir);
							}
						}
					}
					File remoteFile = new File(directoryH+"/"+file.getName());
					list.add(remoteFile);
					finishFileMap.put(remoteFile.getAbsolutePath(), directoryH+"/"+file.getName());
					//删除搬迁后临时目录中的文件
					if(file.exists()){
						FileUtils.forceDelete(file);
					}
					//删除已搬迁完成的文件记录
					fileMap.remove(key); 
					oldFileMap.remove(key);
					//记录还需要搬迁的文件信息
					List<File> onlylist = new ArrayList(fileMap.values());
					File[] arr = (File[])onlylist.toArray(new File[onlylist.size()]);
					msg.setMsgBody(arr);
					//记录以及搬迁成功的文件信息
					msg.setMessageMap(finishFileMap);
					if(logger.isDebugEnabled()) {
						logger.debug("---NO:3---success");
					}
				} catch (Exception e) {
					logger.error("#FileMoveV2Processor#", new BusinessException(9553,"9553.SUBPUB.MOVE",null, e));
					throw new BusinessException(9553,"9553.SUBPUB.MOVE",null, e);
				}finally {
					//接收落地方时间
					msg.getSourceContractInteraction().setDstReplyTime(new Timestamp(System.currentTimeMillis()));
					msg.getSourceContractInteraction().setCenterRecDstTime(new Timestamp(System.currentTimeMillis()));
				}
			}
		}
		if(session!=null){
			session.close();
		}
	}
	
	/**
	 * 端点异常文件重命名回退
	 * @param oldFileMap
	 * @return
	 */
	private File[] exceptionOldFileRename(Map<String, File> oldFileMap){
		if(logger.isDebugEnabled()) {
			logger.debug("endpoint exception ! so file rename back!");
		}
		List<File> list = new ArrayList<File>();
		Iterator<Entry<String, File>> itor = oldFileMap.entrySet().iterator();
		while(itor.hasNext()){
			Entry<String, File> e = itor.next();
			String key = e.getKey();
			File newFile = e.getValue();
			if(newFile.exists()){
				File oldFile =  new File(key);
				if(newFile.renameTo(oldFile)){
					list.add(oldFile);
				}
			}
			if(logger.isDebugEnabled()) {
				logger.debug("rename back:{0}",key);
			}
		}
		return (File[])list.toArray(new File[list.size()]);
	}
	
	/**
	 * 格式化文件名称
	 * @param fileName
	 * @param dirBean
	 * @return
	 */
	private String getFileName(String fileName,String fileFormats) throws Exception{
		String filename = null;										//格式化后文件名称
		String name =null;
		String suffix = "";
		int flag = fileName.lastIndexOf('.');
		if(flag != -1) {
			filename = fileName.substring(0,flag);
			suffix = fileName.substring(flag+1,fileName.length());	//获取后缀名
		}
		
		if(suffix.length() == 0){
			filename = fileName;
		}
		try {
			if(fileFormats==null || "".equals(fileFormats)){
				name = filename+new SimpleDateFormat("_yyyyMMdd").format(new Date());
				if(suffix.length() > 0) {
					name = name + "."+suffix;
				}
			}else{
				name =fileExpr(filename, suffix, fileFormats);
			}
			return name;
		} catch (Exception e) {
			String errorInfo="Expression does not regulate "+fileFormats;
			logger.error("#FileMoveV2Processor#", new BusinessException(9211, errorInfo, null));
			throw e;
		}
	}
	
	
	/**
	 * IKexpression 解析表达式
	 * @param filename
	 * @return
	 */
	public String fileExpr(String filename,String suffix, String expression){
	    List<Variable> variables = new ArrayList<Variable>();  
	    variables.add(Variable.createVariable("filename", filename));
	    if(!expression.contains("changeSuffix") && suffix.length() > 0) {
	    	expression += "+$changeSuffix(suffix)";
	    	variables.add(Variable.createVariable("suffix", suffix));
	    }
	    //expression = "filename+$getCurrTime(\"yyyy-MM-dd\")+$changeSuffix(\"cvs\")";  
	    //执行表达式  
	    Object result = ExpressionEvaluator.evaluate(expression,variables);  
	    return result == null ? "" : result.toString();
	}
	
	private Map<String,String> endpointValue(Endpoint endpoint,SerInvokeIns serInvokeIns){
		Map<String,String> map = new HashMap<String,String>();
		Object fileFormatObj = endpoint.getAttrMap().get(EndpointAttr.FILE_FORMATS);
		String fileFormats = null;
		if(fileFormatObj == null) {
			fileFormats = "filename";
		} else {
			fileFormats = fileFormatObj.toString();
		}
		map.put(EndpointAttr.FILE_FORMATS, fileFormats);
		
		Object fileDirTypeObj = endpoint.getAttrMap().get(EndpointAttr.FILE_DIR_TYPE);
		String fileDirType = "R";
		if(fileDirTypeObj!=null && !StringUtil.isBlank(fileDirTypeObj.toString())){
			fileDirType = fileDirTypeObj.toString();
		}
		map.put(EndpointAttr.FILE_DIR_TYPE, fileDirType);
		
		Object fileTagerDirObject = endpoint.getAttrMap().get(EndpointAttr.LINK_FILE_DIR);
		String fileTagerDir = (String) fileTagerDirObject;
		if(fileTagerDir==null || "".equals(fileTagerDir)){
			throw new BusinessException(9556,"9556.SUBPUB.FILEDIR.ERROR", new String[]{"fileTagerDir="+fileTagerDir}, null);
		}
		//替换动态目录路径
		fileTagerDir = Constant.replacePath(fileTagerDir);
		map.put(EndpointAttr.LINK_FILE_DIR, fileTagerDir);
		
		String userPath = FileUtils.getUserDirectoryPath()+File.separator+"tempfile";
		if(!StringUtil.isBlank(backupTempDir)){
			userPath = backupTempDir+File.separator+"tempfile";
		}
		String fileBackupDir = null;
		Object fileBackupDirObj = endpoint.getAttrMap().get(EndpointAttr.BACKUP_FILE_DIR);
		if (fileBackupDirObj != null && !"".equals(fileBackupDirObj)) {
			fileBackupDir = (String) fileBackupDirObj+File.separator+endpoint.getEndpointId();
		} else {
			fileBackupDir = userPath + File.separator+ serInvokeIns.getSerInvokeInsId() + File.separator+"backup"+File.separator+endpoint.getEndpointId();
		}
		map.put(EndpointAttr.BACKUP_FILE_DIR, fileBackupDir);
		
		String postAction = Constant.POST_ACTION_DEL;
		Object postActionObj = endpoint.getAttrMap().get(EndpointAttr.ATTR_SPEC_CODE_POST_READ_ACTION);
		if(postActionObj != null){
			postAction =  (String) postActionObj;
		}
		map.put(EndpointAttr.ATTR_SPEC_CODE_POST_READ_ACTION, postAction);
		
		//加入动态目录pattern
		Object dirDatePatternObj = endpoint.getAttrMap().get(EndpointAttr.DIR_DATE_PATTERN);
		String dirDatePattern = "";
		if(dirDatePatternObj!=null && !StringUtil.isBlank(dirDatePatternObj.toString())){
			dirDatePattern = dirDatePatternObj.toString();
		}
		map.put(EndpointAttr.DIR_DATE_PATTERN, dirDatePattern);
		return map;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public void subtraThreadNum(String servId) throws EAAPException {
		// TODO Auto-generated method stub

	}
	
	public void setCacheService(IMemcacheManageServ cacheService) {
		this.cacheService = cacheService;
	}

	public String getBackupTempDir() {
		return backupTempDir;
	}

	public void setBackupTempDir(String backupTempDir) {
		this.backupTempDir = backupTempDir;
	}
}
