package com.web.demo.batch.config;

import com.web.demo.batch.listen.CountriesJobListener;
import com.web.demo.batch.process.CountriesProcessor;
import com.web.demo.batch.read.CountriesReader;
import com.web.demo.batch.write.CountriesWriter;
import com.web.demo.dtos.CountriesDTO;
import com.web.demo.entities.Countries;
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

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class CountriesBatchConfig extends DefaultBatchConfigurer {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    CountriesWriter countriesWriter;

    @Autowired
    public void setCountriesWriter(CountriesWriter countriesWriter) {
        this.countriesWriter = countriesWriter;
    }

    @Autowired
    private CountriesProcessor countriesProcessor;

    @Bean
    public Job importUserJob(CountriesJobListener listener) {
        return jobBuilderFactory.get("countriesJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<CountriesDTO, Countries>chunk(100)
                .reader(new CountriesReader().reader())
                .processor(countriesProcessor)
                .writer(countriesWriter)
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

