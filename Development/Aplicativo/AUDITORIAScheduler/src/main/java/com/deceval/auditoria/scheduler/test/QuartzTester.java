package com.deceval.auditoria.scheduler.test;

import com.deceval.auditoria.scheduler.server.AUDITORIAQuartzServer;

public class QuartzTester {
	
	public static void main(String args[]) throws Exception {
		AUDITORIAQuartzServer qserver=new AUDITORIAQuartzServer();
		qserver.startServer();
		try {
            Thread.sleep(300L * 1000L); 
        } catch (Exception e) {
        }
        
        qserver.shutDownServer();
	}
}
