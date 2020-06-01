package com.deceval.auditoria.scheduler.job;

import org.quartz.Job;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ExampleJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("******************************This is an example job!!!!**************************");
		String jobName = context.getJobDetail().getFullName();
		System.out.println("This is "+jobName+" job!!!! executed by Name:"+context.getJobDetail().getJobDataMap().get("name")+
				"Surname: "+context.getJobDetail().getJobDataMap().get("surname"));	    
	}

}
