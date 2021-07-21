package com.web.demo.batch.listen;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CountriesJobListener extends JobExecutionListenerSupport {

    long startTime = 0;

    @Override
    public void afterJob(JobExecution jobExecution) {
        long endTime = System.currentTimeMillis() - startTime;
        long totalSeconds = TimeUnit.MILLISECONDS.toSeconds(endTime);
        System.out.println("CountriesJobListener Job Completed totalSeconds endTime:==" + System.currentTimeMillis() + "===totalSeconds:==" + totalSeconds);
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("CountriesJobListener Job Started startTime:==" + startTime);
    }
}
