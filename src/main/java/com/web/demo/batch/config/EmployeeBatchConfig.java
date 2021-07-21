package com.web.demo.batch.config;

import com.web.demo.batch.listen.EmployeeJobListener;
import com.web.demo.batch.process.EmployeeProcessor;
import com.web.demo.batch.read.EmployeeReader;
import com.web.demo.batch.write.EmployeeWriter;
import com.web.demo.dtos.EmployeeDTO;
import com.web.demo.entities.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.sql.DataSource;

/*@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing*/
public class EmployeeBatchConfig extends DefaultBatchConfigurer {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private EmployeeWriter employeeWriter;

    @Autowired
    private EmployeeProcessor employeeProcessor;

    @Bean
    public Job importUserJob(EmployeeJobListener listener) {
        return jobBuilderFactory.get("employeeJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<EmployeeDTO, Employee>chunk(100)
                .reader(new EmployeeReader().reader())
                .processor(employeeProcessor)
                .writer(employeeWriter)
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
