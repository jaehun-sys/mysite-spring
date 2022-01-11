package com.javaex.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 *스케쥴 Job 실행 클래스
 */
public class JobExcutor extends QuartzJobBean {

  @Override
  protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
    // TODO Auto-generated method stub
    // 실제 수행할 로직..
  }

}