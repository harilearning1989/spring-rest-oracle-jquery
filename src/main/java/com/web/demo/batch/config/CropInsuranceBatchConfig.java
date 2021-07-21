package com.web.demo.batch.config;

import com.web.demo.batch.exception.FileVerificationSkipper;
import com.web.demo.batch.listen.CropInsuranceJobListener;
import com.web.demo.batch.process.CropInsuranceProcessor;
import com.web.demo.batch.read.CropInsuranceReader;
import com.web.demo.batch.write.CropInsuranceWriter;
import com.web.demo.dtos.CropInsuranceDTO;
import com.web.demo.entities.CropInsurance;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import javax.sql.DataSource;

/*@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing*/
public class CropInsuranceBatchConfig extends DefaultBatchConfigurer {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CropInsuranceWriter cropInsuranceWriter;

    @Autowired
    private CropInsuranceProcessor cropInsuranceProcessor;

    @Bean
    public Job importUserJob(CropInsuranceJobListener listener) {
        return jobBuilderFactory.get("cropInsuranceJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<CropInsuranceDTO, CropInsurance>chunk(100)
                .reader(new CropInsuranceReader().reader())
                .faultTolerant()
                .skipPolicy(fileVerificationSkipper())
                .processor(cropInsuranceProcessor)
                .writer(cropInsuranceWriter)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        // override to do not set datasource even if a datasource exist.
        // initialize will use a Map based JobRepository (instead of database)
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        simpleAsyncTaskExecutor.setConcurrencyLimit(5);
        return simpleAsyncTaskExecutor;
    }

    @Bean
    public SkipPolicy fileVerificationSkipper() {
        return new FileVerificationSkipper();
    }

}
