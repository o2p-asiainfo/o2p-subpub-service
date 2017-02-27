package com.ailk.eaap.o2p.jms;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.jms.Message;
import javax.jms.MessageListener;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.jms.support.converter.MessageConverter;

import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.o2p.common.util.Constant;
import com.ailk.eaap.o2p.common.util.zookeeperUtil.ZooKeeperReentrantLock;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.o2p.util.file.remote.session.model.ExtAttr;
import com.ailk.eaap.op2.bo.CacheFlagCommon;
import com.ailk.eaap.op2.bo.Tenant;
import com.ailk.eaap.op2.common.CommonUtil;
import com.ailk.eaap.op2.common.EAAPException;
import com.ailk.eaap.op2.common.JsonUtil;
import com.ailk.eaap.op2.serviceagent.common.EOPDomain;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.log.MessageLogService;
import com.ailk.eaap.op2.serviceagent.route.service.IRouteServ;
import com.ailk.eaap.op2.serviceagent.taskflag.ITaskCacheService;
import com.ailk.eaap.op2.serviceagent.taskflag.impl.TaskCacheService;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.SerInvokeIns;
import com.ailk.eaap.op2.bo.Service;
import com.asiainfo.integretion.o2p.serviceagent.cache.IMemcacheManageServ;

/**
 * 
 * @author zhuangyq
 *
 */
public class FileJmsListener implements MessageListener{
	
	private static final Logger LOG = Logger.getLog(FileJmsListener.class);
	
	private MessageConverter messageConverter;
	
	private IRouteServ routeServ;
	
	private MessageLogService messageLogService;
	
	private IMemcacheManageServ cacheService;
	
	private ITaskCacheService taskCacheService;
	
	private String destinationName;
	
	@Override
	public void onMessage(Message message) {
		@SuppressWarnings("rawtypes")
		MessageBO messageBo = null;
		String[] taskKeys = null;
		boolean needMinus = false;
		String jsonObject = null,taskStyle = null;
		Integer parallelismDegree = -1,excutedStatus = -1;
		try{
			Object msg = messageConverter.fromMessage(message);
			jsonObject = msg.toString();
			if(jsonObject!=null && !jsonObject.equals("")){
				JSONObject jb 			= JSONObject.fromObject(jsonObject);
				Integer serInvokeInsId 	= jb.getInt("objId");
				taskStyle 		        = jb.getString("taskStyle");
				JSONArray jsonArray 	= jb.getJSONArray("taskKeys");
				taskKeys  = new String[jsonArray.size()];
				for(int i = 0; i < jsonArray.size(); i++){
					taskKeys[i] = (String) jsonArray.get(i);
				}
				List<ExtAttr> moveFileInfos=new ArrayList<ExtAttr>();
				if(jb.get("objParams")!=null){
					moveFileInfos=JSONArray.toList(jb.getJSONArray("objParams"),new ExtAttr(),new JsonConfig());
				}
				Integer tenantId = null;
				if(jb.containsKey("tenantId")) {
					tenantId = jb.getInt("tenantId");
				}
				if(tenantId == null) {
					tenantId = CacheKey.defaultTenantId;
				}
				if(jb.get("parallelismDegree") != null) {
					parallelismDegree = jb.getInt("parallelismDegree");
				}
				if(serInvokeInsId==null || serInvokeInsId==-1){
					return;
				}
				SerInvokeIns serInvokeIns = (SerInvokeIns)cacheService.getKey(CacheKey.serInvokeIns + serInvokeInsId,tenantId);
				if(serInvokeIns!=null){
					//非并发任务，把Ready改为Running，防止并发加锁
					if(!taskCacheService.isConcurrencyTask(taskStyle) || parallelismDegree != -1) {
						ZooKeeperReentrantLock lock = null;
						try {
							lock = new ZooKeeperReentrantLock(String.valueOf(serInvokeInsId));
							if(lock.lock(3, TimeUnit.MINUTES)) {
								if(!taskCacheService.currentTaskAllowExcute(taskKeys, taskStyle, parallelismDegree)) {
									return;
								}
								needMinus = taskCacheService.regAndUpdateMemcache(taskStyle, taskKeys, parallelismDegree, CacheFlagCommon.TASK_STATUS_RUNNING,tenantId);
							}
						} finally {
							if(lock != null) {
								lock.release();
							}
						}
					}
					messageBo = parseMessageBo(tenantId, taskStyle, taskKeys,moveFileInfos,
							serInvokeIns);
					LOG.info("#o2p-subpub-service# Begin Message Route: SerInvokeIns Id : {0},Name:{1}, Service Code:{2},Thread {3}",serInvokeIns.getSerInvokeInsId(),
							serInvokeIns.getSerInvokeInsName(),serInvokeIns.getService().getServiceCode(),Thread.currentThread().getName());
					//启动消息流
					long starttime= System.currentTimeMillis();	
					try {
						routeServ.route(messageBo);
					} catch(Exception e) {
						excutedStatus = CacheFlagCommon.TASK_STATUS_EXCEPTION;
						throw e;
					}
					if(!taskCacheService.isErrorExcutor(taskStyle, taskKeys)) {
						excutedStatus = CacheFlagCommon.TASK_STATUS_OVER;
					}
					long endtime= System.currentTimeMillis();
					LOG.info("#o2p-subpub-service# End Message Route: SerInvokeIns Id : {0},Name:{1}, Service Code:{2},Thread {3},Duration {4} Seconds",
							serInvokeIns.getSerInvokeInsId(),serInvokeIns.getSerInvokeInsName(),Thread.currentThread().getName(),serInvokeIns.getService().getServiceCode(),(endtime-starttime)/1000);
				}
			}
		}catch (Exception e) {
			LOG.error("FV1JmsListener.onMessage hit and some bad happend,and taskContent="+jsonObject, e);	
			EAAPException ex = new EAAPException("SUBPUB","9252",((BusinessException) e).getResult().getMsg(),e);			
			if(messageBo != null) {
				messageBo.setEAAPException(ex);
			}
		}finally{
			try{
				if(parallelismDegree == -1 && excutedStatus != -1) {
					taskCacheService.updateMemcache(taskStyle, taskKeys, excutedStatus);
				}
				if(needMinus) {
					taskCacheService.changeRunningTaskNum(taskKeys, TaskCacheService.CHANGE_TYPE_MINUS, 1,parallelismDegree);
				}
				messageLogService.sendMessageLog(messageBo);
			}catch(Exception e){
				LOG.error("FV1JmsListener.onMessage hit and some bad happend,and taskContent="+jsonObject, e);	
			}
		} 
		
	}
	@SuppressWarnings("rawtypes")
	private MessageBO parseMessageBo(Integer tenantId, String taskStyle, String[] taskKeys,
			List<ExtAttr> moveFileInfos, SerInvokeIns serInvokeIns) {
		MessageBO messageBo;
		messageBo = new MessageBO();
		messageBo.getSourceContractInteraction().setCenterRecReqTime(new Timestamp(System.currentTimeMillis()));
		
		messageBo.setSrcsyscode(serInvokeIns.getComponentCode());
		messageBo.setReqorrsp(EOPDomain.REQ_FLAG);
		//增加记录文件交易流水号
		String uuid = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
		messageBo.setDstTranId(uuid);
		
		Service service  = serInvokeIns.getService();
		messageBo.setTaskFlag(true);
		messageBo.setService(service);
		messageBo.setServiceCode(service.getServiceCode());
		messageBo.setRegServiceCode(service.getServiceCode());
		messageBo.setRegServiceVersion(service.getServiceVersion());
		messageBo.setContractVersion(service.getContractVersion());
		messageBo.setSerInvokeIns(serInvokeIns);
		messageBo.setQueueName(destinationName);
		
		messageBo.setTaskStyle(taskStyle);
		messageBo.setMoveFileInfos(moveFileInfos);
		if(tenantId == null) {
			tenantId = CacheKey.defaultTenantId;
		}
		Tenant ten = (Tenant) cacheService.getObjByKey(CacheKey.TENANT+tenantId);
		if(ten != null) {
			messageBo.setTenant(ten);
		}
		messageBo.setServiceStyle(Constant.SERVICE_STYLE_ASYNC);
		if(!messageBo.getTaskStyle().equals(TaskContentBean.CONCURRENCY_TASK)){
			messageBo.setTaskCacheFlag(taskKeys);
		}
		//date formate: yyyyMMddHHmmss
		String reqTime = CommonUtil.getFormatTimeString(new Date());
		messageBo.setSrcReqTime(reqTime);
		messageBo.setResponseDes("");
		return messageBo;
	}
	
	public void setMessageConverter(MessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}
	public void setRouteServ(IRouteServ routeServ) {
		this.routeServ = routeServ;
	}
	public void setMessageLogService(MessageLogService messageLogService) {
		this.messageLogService = messageLogService;
	}
	public void setCacheService(IMemcacheManageServ cacheService) {
		this.cacheService = cacheService;
	}
	public void setTaskCacheService(ITaskCacheService taskCacheService) {
		this.taskCacheService = taskCacheService;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
}
