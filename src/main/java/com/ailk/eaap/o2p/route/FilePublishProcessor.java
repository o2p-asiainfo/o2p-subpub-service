/** 
 * Project Name:o2p-subpub-service 
 * File Name:FilepublishProcessor.java 
 * Package Name:com.ailk.eaap.o2p.route 
 * Date:2014年9月28日上午9:53:09 
 * Copyright (c) 2014, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.o2p.route;  

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.ailk.eaap.op2.common.EAAPException;
import com.ailk.eaap.op2.serviceagent.common.EOPDomain;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.route.service.EndpointProcessor;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.Endpoint;
import com.ailk.eaap.op2.bo.RouteEndpoint;
import com.ailk.eaap.op2.bo.ToRouteEndpoint;

/** 
 * ClassName:FilePublishProcessor
 * Function: FilePublishProcessor
 * Reason:   FilePublishProcessor
 * Date:     2014年9月28日 上午9:53:09
 * @author   mf 
 * @version   
 * @since    JDK 1.6     
 */
public class FilePublishProcessor  implements EndpointProcessor{
	
	private final static Logger logger = Logger.getLog(FilePublishProcessor.class);
	
	public MessageBO process(Endpoint endpoint, MessageBO msg)
			throws EAAPException {
		StringBuffer response = new StringBuffer();
		int publishNum = 0;
		Map<String,String> endpointMap = new HashMap<String,String>();
		//存放执行完成的文件
        Map<String,File[]> fileMap = new HashMap<String,File[]>();
        Map<String,File[]> map = new HashMap<String,File[]>();
        response.append(" <ENDPOINTID=").append(endpoint.getEndpointId()).append(">");
		try{
			response.append("#").append(new java.sql.Timestamp(System.currentTimeMillis()).toString()).append("#");
			if(logger.isInfoEnabled()){
				logger.info("#FilePublishProcessor START# SerInvokeInsName:{0} ,curryEndpointId:{1}",msg.getSerInvokeIns().getSerInvokeInsName(),endpoint.getEndpointId());
			}
			File[] fileArray = null;
			 if(msg.getMsgBody() instanceof File[]){
				 fileArray = (File[])msg.getMsgBody();
				 publishNum = fileArray.length;
			}else {
				return msg;
			}
			if(fileArray.length<=0){
				 return msg;
			}
			 
			RouteEndpoint currryEndpoint = msg.getCurrryRouteEndpoint();
			if(currryEndpoint!=null &&currryEndpoint.getChildEndpoints()!=null){
	            List<ToRouteEndpoint> toRouteEndpoints = currryEndpoint.getChildEndpoints();
	            String srcDir = msg.getTempFileDirName();
	            if(StringUtils.isBlank(srcDir)){
	            	throw new BusinessException(9555, "9555.SUBPUB.TEMPFILEDIR", new String[]{srcDir}, null);
	            }
	            File tempDirFile =  new File(srcDir);
	            List<String> tempDirList = new ArrayList<String>();
	            //copy file dir
            	for(int i=0; i<toRouteEndpoints.size(); i++) {
            		
            		ToRouteEndpoint re = toRouteEndpoints.get(i);
            		String endPointId = String.valueOf(re.getToEndpoint().getCurrentEndpoint().getEndpointId());
            		
            		String tempEndpointDir = tempDirFile.getParent()+File.separator+endPointId+File.separator;
            		tempDirList.add(tempEndpointDir);
            		endpointMap.put(endPointId, tempEndpointDir);
            		response.append(" publish to ")
            		.append(tempEndpointDir).append(" success num:").append("<*")
            		.append(endPointId).append("*>").append(" fail num:").append("<*failNum*>");
            		
            		File tempDir = new File(tempEndpointDir);
    				if(!tempDir.exists()){
    					FileUtils.forceMkdir(tempDir);
    				}
            	}
            	
            	copyDirectiory(map,fileArray,tempDirList,tempDirFile);
            	endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_SUCCESS);
			}   
		}catch (BusinessException e) {
			endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_FAIL);
			logger.error("#FilePublishProcessor#",new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FilePublishProcessor endpoint="+endpoint.getEndpointId(),e.getResult().toString()}, e));
			throw new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FilePublishProcessor endpoint="+endpoint.getEndpointId(),e.getResult().toString()}, e);
			
		}catch(Exception e ){
			endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_FAIL);
			logger.error("#FilePublishProcessor#",new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FilePublishProcessor endpoint="+endpoint.getEndpointId(),e.getMessage()}, e));
			throw new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FilePublishProcessor endpoint="+endpoint.getEndpointId(),e.getMessage()}, e);
		}finally{
			int publiscFileNum = 0;
        	String resDes = response.toString();
        	Iterator<Entry<String, String>> itor = endpointMap.entrySet().iterator();     
	        while(itor.hasNext()){   
	        	Entry<String, String> e = itor.next(); 
	        	String key = e.getKey();
        		String dirKey = e.getValue();
        		File[] pubFileArray = map.get(dirKey);
        		fileMap.put(key, pubFileArray);
        		publiscFileNum += pubFileArray.length;
        		int successNum = pubFileArray.length;
        		int failNum = publishNum-pubFileArray.length;
        		resDes = resDes.replace("<*"+key+"*>", ""+successNum).replace("<*failNum*>", ""+failNum);
        	}
        	
        	msg.setMsgBody(fileMap);
        	msg.setOutputSuccessFileNum(publiscFileNum);
        	msg.setMessageMap(endpointMap);	
        	msg.setSuccessNum(publiscFileNum);
        	msg.setResponseDes(msg.getResponseDes()+resDes);
        	
        	if(logger.isInfoEnabled()){
				logger.info("#FilePublishProcessor END# SerInvokeInsName:{0} ,curryEndpointId:{1},publisc file to tagerDir {2} ",msg.getSerInvokeIns().getSerInvokeInsName(),endpoint.getEndpointId(),fileMap);
			}
		}
		return msg;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public void subtraThreadNum(String servId) throws EAAPException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * copyDirectiory:(这里用一句话描述这个方法的作用). 复制目录下的文件 
	 * 
	 * @author mf 
	 * @param fileArray  源文件数组
	 * @param tempDirList 目标地址目录list
	 * @param tempDirFile 临时文件 
	 * @throws IOException 
	 * @since JDK 1.6
	 */
	 private void copyDirectiory(Map<String,File[]> map,File[] fileArray,List<String> tempDirList,File tempDirFile) throws IOException{
	        Map<String,File> fileMap = new HashMap<String,File>();
	        try{
		        //获取源文件夹当下的文件或目录
		        for (int i = 0; i < fileArray.length; i++) {
		            if(fileArray[i].isFile()){
		            	//源文件
		            	File sourceFile=fileArray[i];
		            	for(String dir : tempDirList){
		            		//目标文件
		            		String hierarchy = sourceFile.getAbsolutePath().replace(tempDirFile.getAbsolutePath(), "");
		            		File copyFile=new File(dir+File.separator+hierarchy);
		            		//复制到子目录下
		            		FileUtils.copyFile(sourceFile, copyFile);
		            		fileMap.put(dir+"_@_"+fileArray[i].getAbsolutePath(), copyFile);
		            	}
	            		FileUtils.deleteQuietly(sourceFile);
	            	}
		        }
		       
		        for(String dir : tempDirList){
		        	  File[] copyFileArray = new File[fileArray.length];
		        	  for (int i = 0; i < fileArray.length; i++) {
		        		  File f = fileMap.get(dir+"_@_"+fileArray[i].getAbsolutePath());
		        		  copyFileArray[i] = f;
		        	  }
		        	  map.put(dir, copyFileArray);
		        }
		        
		 }catch(Exception e){
			 throw new BusinessException(9557, "9557.SUBPUB.PUBLISH.ERROR", new String[]{tempDirFile.getAbsoluteFile().toString(),e.getMessage()}, e);
		 }
	 }
}