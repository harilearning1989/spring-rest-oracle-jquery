package com.web.demo.batch.read;

import com.web.demo.dtos.CountriesDTO;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class CountriesReader extends FlatFileItemReader<CountriesDTO> {

    @BeforeStep
    public void beforeStep(final StepExecution stepExecution) {
        JobParameters parameters = stepExecution.getJobExecution().getJobParameters();
        System.out.println("fileName===" + parameters.getString("fileName"));
    }

    @Bean
    public FlatFileItemReader<CountriesDTO> reader() {
        FlatFileItemReader<CountriesDTO> reader = new FlatFileItemReader<CountriesDTO>();
        reader.setResource(new ClassPathResource("DataFiles/CountriesRegions.csv"));

        reader.setLineMapper(new DefaultLineMapper<CountriesDTO>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"name", "alpha2", "alpha3", "countrycode", "region","subregion",
                        "intermediateregion", "regioncode", "subregioncode","intermediateregioncode"});
            }});

            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(CountriesDTO.class);
            }});

        }});
        reader.setLinesToSkip(1);
        return reader;
    }
}
