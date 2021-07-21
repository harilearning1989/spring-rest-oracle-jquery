package com.web.demo.batch.read;

import com.web.demo.dtos.EmployeeDTO;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class EmployeeReader extends FlatFileItemReader<EmployeeDTO> {

    @Bean
    public FlatFileItemReader<EmployeeDTO> reader() {
        FlatFileItemReader<EmployeeDTO> reader = new FlatFileItemReader<EmployeeDTO>();
        reader.setResource(new ClassPathResource("DataFiles/employee.csv"));

        reader.setLineMapper(new DefaultLineMapper<EmployeeDTO>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"first_name", "last_name", "company_name", "address", "city", "county", "state", "zip"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(EmployeeDTO.class);
            }});

        }});
        reader.setLinesToSkip(1);
        return reader;
    }

}
