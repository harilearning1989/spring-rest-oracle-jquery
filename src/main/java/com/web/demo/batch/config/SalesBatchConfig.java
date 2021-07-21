package com.web.demo.batch.config;

import com.web.demo.batch.listen.SalesOrderJobListener;
import com.web.demo.batch.process.SalesOrderProcessor;
import com.web.demo.batch.read.SalesOrderReader;
import com.web.demo.batch.write.SalesOrderWriter;
import com.web.demo.dtos.SalesOrderDTO;
import com.web.demo.entities.SalesOrder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.sql.DataSource;

/*@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing*/
public class SalesBatchConfig extends DefaultBatchConfigurer {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private SalesOrderWriter salesOrderWriter;

    @Autowired
    private SalesOrderProcessor salesOrderProcessor;

    @Bean
    public Job importUserJob(SalesOrderJobListener listener) {
        return jobBuilderFactory.get("salesOrderJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<SalesOrderDTO, SalesOrder>chunk(100)
                .reader(new SalesOrderReader().reader())
                .processor(salesOrderProcessor)
                .writer(salesOrderWriter)
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
}

