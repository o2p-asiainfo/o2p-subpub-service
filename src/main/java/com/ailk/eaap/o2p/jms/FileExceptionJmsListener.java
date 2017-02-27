package com.ailk.eaap.o2p.jms;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.jms.support.converter.MessageConverter;

import com.ailk.eaap.op2.bo.ExceptionDealInfo;
import com.ailk.eaap.op2.common.EAAPException;
import com.ailk.eaap.op2.common.EAAPTags;
import com.ailk.eaap.op2.serviceagent.activemq.ActivemqMessageUtil;
import com.ailk.eaap.op2.serviceagent.common.ErrorDomain;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.log.MessageLogService;
import com.ailk.eaap.op2.serviceagent.route.service.IRouteServ;
import com.ailk.eaap.op2.serviceagent.route.service.IServiceExchangeService;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractInteraction;
import com.ailk.eaap.op2.bo.LogMessageObject;

public class FileExceptionJmsListener implements MessageListener{

	private static final Logger LOG = Logger.getLog(FileExceptionJmsListener.class);

	private IRouteServ routeServ;

	private ActivemqMessageUtil  reTryExceptionDealInfoMessage;

	private MessageLogService messageLogService;

	private IServiceExchangeService serviceExchangeService;

	private MessageConverter messageConverter;

	@Override
	public void onMessage(Message message) {
		MessageBO messageBo = null;
		ExceptionDealInfo info = null;
		try{
			Serializable msg = (Serializable) messageConverter.fromMessage(message);
			if(msg != null){
				info = (ExceptionDealInfo)msg;
				byte[]  messageBoByte = info.getMessageBoByte();
				// bytearray to object  
				ByteArrayInputStream bi = new ByteArrayInputStream(messageBoByte);  
				ObjectInputStream oi = new ObjectInputStream(bi);  
				messageBo = (MessageBO) oi.readObject();  
				bi.close();  
				oi.close();  
				if(messageBo==null){
					if(LOG.isDebugEnabled()){
						LOG.debug("Exception messageBo is null");
					}
				}else{
					//消息流异常重试，异常重试初始化数量为0
					messageBo.setInputFileNum(0);
					messageBo.setOutputErrFileNum(0);
					messageBo.setOutputSuccessFileNum(0);
					messageBo.setFailNum(0);
					messageBo.setSuccessNum(0);
					messageBo.setFailMsg("");
					messageBo.setLogMessageObject(new LogMessageObject());
					messageBo.setResponseDes("");

					messageBo.setSourceContractInteraction(new ContractInteraction());
					messageBo.getSourceContractInteraction().setCenterRecReqTime(new Timestamp(System.currentTimeMillis()));
					messageBo.setExceptionTryNum(info.getTryNum()+1);
					serviceExchangeService.exchange(messageBo.getCurrryRouteEndpoint().getCurrentEndpoint(), messageBo);
					routeServ.callEndpoint(messageBo.getCurrryRouteEndpoint(), messageBo);
					messageLogService.sendMessageLog(messageBo);
					//执行结果反馈异常调度表
					if(!info.getTryStatus().equals(ExceptionDealInfo.TRY_STATUS_T)){
						info.setReTryResultDate(new Timestamp(System.currentTimeMillis()));
						info.setTryStatus(ExceptionDealInfo.TRY_STATUS_C);
						reTryExceptionDealInfoMessage.sendObjectMsg(info);
					}
				}
			}else{
				if(LOG.isDebugEnabled()){
					LOG.debug("Exception messageReceiver is null");
				}
			}
		}catch(Exception e){
			doWithException(e, messageBo, info);
		}

	}
	
	public void doWithException(Exception e, MessageBO messageBo, ExceptionDealInfo info) {
		EAAPException ex = null;
		if(e instanceof BusinessException){
			BusinessException be = (BusinessException)e;
			ex = new EAAPException(EAAPTags.SEG_DRAVER_SIGN,be.getResult().getCode()+"",be.getResult().getMsg(),be);
		}else if(e instanceof EAAPException){
			ex = (EAAPException)e;
		}else{
			ex = new EAAPException(EAAPTags.SEG_DRAVER_SIGN,ErrorDomain.ERROR_CODE_9999,e.getMessage(),e);
		}
		if(messageBo!=null && messageBo.getCurrryRouteEndpoint()!=null){
			//异常端点可能发生变化
			int currentEndPointId = messageBo.getCurrryRouteEndpoint().getCurrentEndpoint().getEndpointId();
			String currentEndPointName = messageBo.getCurrryRouteEndpoint().getCurrentEndpoint().getEndpointName();
			if(currentEndPointId != info.getEndPointId()){
				info.setEndPointId(currentEndPointId);
				info.setEndPointName(currentEndPointName);
			}
			byte[] bytes = null;  
			try {  
				// object to bytearray  
				ByteArrayOutputStream bo = new ByteArrayOutputStream();  
				ObjectOutputStream oo = new ObjectOutputStream(bo);  
				oo.writeObject(messageBo);  
				bytes = bo.toByteArray();  
				bo.close();  
				oo.close();  
			} catch (Exception ee) {  
				LOG.error(LogModel.EVENT_APP_EXCPT, ee);
			}  
			info.setMessageBoByte(bytes);
		}
		if(ex.toXmlString()!=null){
			if(ex.toXmlString().length()>2048){
				info.setExceptionCode(ex.toXmlString().substring(0, 2040));
			}else{
				info.setExceptionCode(ex.toXmlString());
			}
		}
		if(ex.getMessage()!=null){
			if(ex.getMessage().length()>2048){
				info.setExceptionStack(ex.getMessage().substring(0, 2040));
			}else{
				info.setExceptionStack(ex.getMessage());
			}
		}
		try{
			if(messageBo != null) {
				messageBo.setEAAPException(ex);
			}
			messageLogService.sendMessageLog(messageBo);
			//执行结果反馈异常调度表
			if(info != null && !ExceptionDealInfo.TRY_STATUS_T.equals(info.getTryStatus())){
				info.setReTryResultDate(new Timestamp(System.currentTimeMillis()));
				info.setTryStatus(ExceptionDealInfo.TRY_STATUS_E);
				reTryExceptionDealInfoMessage.sendObjectMsg(info);
			}
		}catch(Exception ee){
			LOG.error(LogModel.EVENT_APP_EXCPT, ee);
		}
		LOG.error(LogModel.EVENT_APP_EXCPT, e);
	}

	public void setRouteServ(IRouteServ routeServ) {
		this.routeServ = routeServ;
	}

	public void setReTryExceptionDealInfoMessage(
			ActivemqMessageUtil reTryExceptionDealInfoMessage) {
		this.reTryExceptionDealInfoMessage = reTryExceptionDealInfoMessage;
	}

	public void setMessageLogService(MessageLogService messageLogService) {
		this.messageLogService = messageLogService;
	}

	public void setServiceExchangeService(
			IServiceExchangeService serviceExchangeService) {
		this.serviceExchangeService = serviceExchangeService;
	}

	public void setMessageConverter(MessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}

}
