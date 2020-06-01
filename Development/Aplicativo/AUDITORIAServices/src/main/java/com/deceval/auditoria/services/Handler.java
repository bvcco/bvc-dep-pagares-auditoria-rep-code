package com.deceval.auditoria.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class Handler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext messageContext) {

        boolean inMessage = !(Boolean) messageContext.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (inMessage) {
            SOAPMessage message = messageContext.getMessage();
            String home = System.getProperty("user.home");
            try {
                message.writeTo(new FileOutputStream(new File(home, "WSAuditoriaInputMessageDump.log")));
            } catch (SOAPException ex) {
                System.out.println("Exception: " + ex);
            } catch (IOException ex) {
                System.out.println("Exception: " + ex);
            }
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }
}
