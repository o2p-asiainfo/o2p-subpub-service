package com.ailk.eaap.o2p.service;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;

public class SubMessageUtil {
	
private static final Logger log = Logger.getLog(SubMessageUtil.class);
	
	private JmsTemplate jmsTemplate;  
    private Destination destination;  
      
    public JmsTemplate getJmsTemplate() {  
        return jmsTemplate;  
    }  
    public void setJmsTemplate(JmsTemplate jmsTemplate) {  
        this.jmsTemplate = jmsTemplate;  
    }  
    public Destination getDestination() {  
        return destination;  
    }  
    public void setDestination(Destination destination) {  
        this.destination = destination;  
    }  
	
	public  Serializable receiverObjectMsg(){ 
	    ObjectMessage  objMsg = (ObjectMessage)jmsTemplate.receive(destination); 
	     
	    Serializable object = null;
		try {
			object = objMsg.getObject();
		} catch (JMSException e) {
			log.error(LogModel.EVENT_APP_EXCPT, e);
		}
	      
	     return object;
	}
	
	public void sendObjectMsg(final Serializable objectMsg) {  
		
		 jmsTemplate.send(  
		            destination,  
		            new MessageCreator(){  
		                public Message createMessage(Session session) throws JMSException {  
		                    return session.createObjectMessage(objectMsg);
		                }  
		            }  
		        ); 
	}
}
