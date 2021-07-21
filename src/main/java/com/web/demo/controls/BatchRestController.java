package com.web.demo.controls;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("batch")
@Api(value = "BatchRestController")
public class BatchRestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(BatchRestController.class.getName());

    JobLauncher jobLauncher;

    @Autowired
    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    Job job;

    @Autowired
    public void setJob(Job job) {
        this.job = job;
    }

    @ApiOperation(value = "Read Employee by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @RequestMapping("/onDemand")
    public String launchJobOnDemand() throws Exception {

        JobParameters jobParameters = new JobParametersBuilder()
                //.addLong("time", System.currentTimeMillis())
                .addString("fileName", "Hari Reddy")
                .toJobParameters();
        jobLauncher.run(job, jobParameters);

        return "Batch job has been invoked";
    }
}
