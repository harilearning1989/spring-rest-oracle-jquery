package com.web.demo.batch.read;

import com.web.demo.dtos.StudentDTO;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class StudentReader extends FlatFileItemReader<StudentDTO> {

    @Bean
    public FlatFileItemReader<StudentDTO> reader() {
        FlatFileItemReader<StudentDTO> reader = new FlatFileItemReader<StudentDTO>();
        reader.setResource(new ClassPathResource("DataFiles/StudentInfo.csv"));

        reader.setLineMapper(new DefaultLineMapper<StudentDTO>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"STUDENT ID", "STUDENT NAME", "FATHER NAME", "GENDER", "MOBILE", "CATEGORY"});
            }});

            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(StudentDTO.class);
            }});

        }});
        reader.setLinesToSkip(1);
        return reader;
    }
}
