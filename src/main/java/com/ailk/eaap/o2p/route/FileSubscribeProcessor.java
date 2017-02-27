/** 
 * Project Name:o2p-subpub-service 
 * File Name:FileSubscribeProcessor.java 
 * Package Name:com.ailk.eaap.o2p.route 
 * Date:2014年9月28日上午9:53:36 
 * Copyright (c) 2014, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.o2p.route;  

import java.io.File;
import java.util.Hashtable;
import java.util.Map;

import com.ailk.eaap.o2p.util.file.local.LocalFileUtil;
import com.ailk.eaap.op2.common.EAAPException;
import com.ailk.eaap.op2.serviceagent.common.EOPDomain;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.route.service.EndpointProcessor;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.Endpoint;
import com.ailk.eaap.op2.bo.EndpointAttr;

public class FileSubscribeProcessor  implements EndpointProcessor{

	private final static Logger logger = Logger.getLog(FileSubscribeProcessor.class);
	
	public MessageBO process(Endpoint endpoint, MessageBO msg)
			throws EAAPException {
		StringBuffer response = new StringBuffer();
		
		response
		.append(" <ENDPOINTID=")
		.append(endpoint.getEndpointId())
		.append(">");
		
		MessageBO msgCopy = (MessageBO) msg.clone();
		Map<String,File[]> fileMap = null;
		try{
			if(logger.isInfoEnabled()) {
				logger.info("#FileSubscribeProcessor START# SerInvokeInsName:{0} ,curryEndpointId:{1}",msg.getSerInvokeIns().getSerInvokeInsName(),endpoint.getEndpointId());
			}
		
			 if(msgCopy.getMsgBody() instanceof Map){
				 fileMap = (Map<String,File[]>)msgCopy.getMsgBody();
			}else {
				return msgCopy;
			}
			String endpointId =  String.valueOf(endpoint.getEndpointId());
			File[] fileArray =fileMap.get(endpointId);
			if(fileArray==null || fileArray.length<=0){
				 return msgCopy;
			}
			response.append("#")
			.append(new java.sql.Timestamp(System.currentTimeMillis()).toString())
			.append("# have file num:")
			.append(fileArray.length);
			
			String endpointDir = (String)msgCopy.getMessageMap().get(endpointId);
			msgCopy.setTempFileDirName(endpointDir);
			
			String suffix = null;
			Object suffixObj = endpoint.getAttrMap().get(EndpointAttr.MESSAGE_RULE);
			if (suffixObj != null) {
				suffix = (String) suffixObj;
			}
			if(logger.isDebugEnabled()){
				logger.debug("MESSAGE_RULE: ", suffix);
			}
			//解析过滤规则
			String filterExpression = validateExpression(suffix);
			//递归扫描子目录下的文件
			File[] files = LocalFileUtil.dealWithDirectoryFile(fileArray,filterExpression);               
			msgCopy.setMsgBody(files);
			msgCopy.setMessageMap(new Hashtable<String,String>());
			endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_SUCCESS);
			response
			.append(" after subscribe have num:")
			.append(files.length);
			msgCopy.setResponseDes(response.toString());
			msgCopy.setOutputSuccessFileNum(files.length);
			msgCopy.setSuccessNum(files.length);
			
			if(logger.isInfoEnabled()) {
				logger.info("#FileSubscribeProcessor END# SerInvokeInsName:{0} ,curryEndpointId:{1}，subscribe file num:{2}",msg.getSerInvokeIns().getSerInvokeInsName(),endpoint.getEndpointId(),files.length);
			}
		}catch (BusinessException e) {
			msgCopy.setResponseDes(response.toString());
			endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_FAIL);
			logger.error("#FileSubscribeProcessor#",new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FilePublishProcessor endpoint="+endpoint.getEndpointId(),e.getResult().toString()}, e));
			throw new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FilePublishProcessor endpoint="+endpoint.getEndpointId(),e.getResult().toString()}, e);
			
		}catch(Exception e){
			msgCopy.setResponseDes(response.toString());
			endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_FAIL);
			logger.error("#FileSubscribeProcessor#",new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FilePublishProcessor endpoint="+endpoint.getEndpointId(),e.getMessage()}, e));
			throw new BusinessException(9250, "9250.SUBPUB.ENDPOINT.ERROR", new String[]{"FilePublishProcessor endpoint="+endpoint.getEndpointId(),e.getMessage()}, e);
		}
		return msgCopy;
	}
	
	
	private String validateExpression(String filterExpression) {
		boolean valid = true;
		if(filterExpression == null){
			return "";
		}
		while(filterExpression.startsWith("&&") || filterExpression.startsWith("||")) {
			valid = false;
			filterExpression = filterExpression.substring(2);
		}
		if(!valid) {
			logger.warn("Illegal begin: '&&' or '||', which will delete");
			valid = true;
		}
		while(filterExpression.endsWith("&&") || filterExpression.endsWith("||")) {
			valid = false;
			filterExpression = filterExpression.substring(0,filterExpression.length()-2);
		}
		if(!valid) {
			logger.warn("Illegal end: '&&' or '||', which will delete");
			valid = true;
		}
		while(filterExpression.contains("&&&&") || filterExpression.contains("||||")) {
			valid = false;
			filterExpression = filterExpression.replaceAll("\\&\\&\\&\\&", "\\&\\&").replaceAll("\\|\\|\\|\\|", "\\|\\|");
		}
		if(!valid) {
			logger.warn("Illegal substring: '&&&&' or '||||', which will be replaced with '&&' or '||'");
			valid = true;
		}
		while(filterExpression.contains("&&||") || filterExpression.contains("||&&")) {
			valid = false;
			filterExpression = filterExpression.replaceAll("\\&\\&\\|\\|", "\\&\\&").replaceAll("\\|\\|\\&\\&", "\\|\\|");
		}
		if(!valid) {
			logger.warn("Illegal substring: '&&||' or '||&&', which will be replaced with '&&' or '||'");
			valid = true;
		}
		return filterExpression;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public void subtraThreadNum(String servId) throws EAAPException {
		// TODO Auto-generated method stub
		
	}

}
