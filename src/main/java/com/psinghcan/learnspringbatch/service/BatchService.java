package com.psinghcan.learnspringbatch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class BatchService {

    public BatchService(JobLauncher jobLauncher, Job job){
        this.jobLauncher = jobLauncher;
        this.job = job;
    }
    public void startBatchJob(String name){
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder()
                .addString("name", name)
                .addDate("time", new Date());

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    JobExecution jobExecution = jobLauncher.run(job, jobParametersBuilder.toJobParameters());
                    System.out.println("job has been started");
                } catch (Exception e){
                    System.out.println("error " + e);
                }
            }
        });
    }

    private JobLauncher jobLauncher;
    private Job job;
}
