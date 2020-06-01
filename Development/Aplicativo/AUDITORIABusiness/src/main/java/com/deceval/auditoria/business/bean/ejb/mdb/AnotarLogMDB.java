package com.deceval.auditoria.business.bean.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.deceval.auditoria.business.bean.pojo.negocio.NegocioPOJO;
import com.deceval.auditoria.dto.RequestMsgInsertAudObjectDTO;

@MessageDriven(	mappedName = "jms/AUDITORIAQueue", 
				name = "AnotarLogMDB", 
				activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }
			  )
@TransactionAttribute(value = javax.ejb.TransactionAttributeType.NOT_SUPPORTED)	

public class AnotarLogMDB implements MessageListener {
	

  public void onMessage (Message msg) {
    try {
    	ObjectMessage objectMessage = (ObjectMessage)msg;
    	RequestMsgInsertAudObjectDTO reqMsgObj = (RequestMsgInsertAudObjectDTO)objectMessage.getObject();
    	NegocioPOJO negocioPojo = new NegocioPOJO();
    	negocioPojo.crearAnotacionLog(reqMsgObj);
    } catch (Exception e) {
      e.printStackTrace ();
    }
  }
}

