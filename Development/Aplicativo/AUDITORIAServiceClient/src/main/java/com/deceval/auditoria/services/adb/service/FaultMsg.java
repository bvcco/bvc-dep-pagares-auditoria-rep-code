
/**
 * FaultMsg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */

package com.deceval.auditoria.services.adb.service;

public class FaultMsg extends java.lang.Exception{
    
    private com.deceval.auditoria.services.xsd.Fault faultMessage;
    
    public FaultMsg() {
        super("FaultMsg");
    }
           
    public FaultMsg(java.lang.String s) {
       super(s);
    }
    
    public FaultMsg(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(com.deceval.auditoria.services.xsd.Fault msg){
       faultMessage = msg;
    }
    
    public com.deceval.auditoria.services.xsd.Fault getFaultMessage(){
       return faultMessage;
    }
}
    