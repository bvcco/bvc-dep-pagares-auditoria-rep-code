
/**
 * InsertarLogAUDITORIAServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */
    package com.deceval.auditoria.services.adb.service;

import com.deceval.auditoria.services.adb.service.impl.InsertarLogAUDITORIAServiceImpl;
    /**
     *  InsertarLogAUDITORIAServiceSkeleton java skeleton for the axisService
     */
    public class InsertarLogAUDITORIAServiceSkeleton implements InsertarLogAUDITORIAServiceSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param insertarLogRequest0
             * @throws FaultMsg : 
         */
        
                 public com.deceval.auditoria.services.xsd.InsertarLogResponse insertarLog
                  (
                  com.deceval.auditoria.services.xsd.InsertarLogRequest request
                  )
            throws FaultMsg{
                	 
                	 InsertarLogAUDITORIAServiceImpl insertarLogImpl = new InsertarLogAUDITORIAServiceImpl();
                	 return insertarLogImpl.insertarLog(request);
                	 
        }
     
    }
    