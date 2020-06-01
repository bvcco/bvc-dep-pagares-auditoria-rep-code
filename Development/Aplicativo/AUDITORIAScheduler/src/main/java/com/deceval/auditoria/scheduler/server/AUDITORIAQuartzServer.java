package com.deceval.auditoria.scheduler.server;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.deceval.auditoria.util.properties.PropertiesLoader;

public class AUDITORIAQuartzServer {
	
	/**
	 * Scheduler Instance for Quartz 
	 */
	private Scheduler sched = null;
	
	/**
	 * Property which contains the Scheduler configuration file.
	 */
	public static final String QUARTZ_CONFIGURATION_FILE="QUARTZ_CONFIGURATION_FILE";
	
	/**
	 * Property which contains the Scheduler log4j configuration file.
	 */
	public static final String LOG_PROPERTIES_QUARTZ="LOG_PROPERTIES_QUARTZ";
	
	public AUDITORIAQuartzServer()throws SchedulerException{
		 DOMConfigurator.configure(PropertiesLoader
					.loadProperty(LOG_PROPERTIES_QUARTZ));
		 SchedulerFactory sf = new StdSchedulerFactory(PropertiesLoader.loadProperty(QUARTZ_CONFIGURATION_FILE));		 
	     sched = sf.getScheduler();	     	     
	}
	
	public void startServer() throws SchedulerException{
		sched.start();
	}
	
	public void shutDownServer() throws SchedulerException{
		sched.shutdown(true);
		
	}
	
	public List getCurrentlyExecutingJobs() throws SchedulerException{
		return sched.getCurrentlyExecutingJobs();		
	}
	
	public void standByServer() throws SchedulerException{
		sched.standby();
	}
	
}
