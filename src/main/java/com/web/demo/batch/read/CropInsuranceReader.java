package com.web.demo.batch.read;

import com.web.demo.dtos.CropInsuranceDTO;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class CropInsuranceReader extends FlatFileItemReader<CropInsuranceDTO> {

    @BeforeStep
    public void beforeStep(final StepExecution stepExecution) {
        JobParameters parameters = stepExecution.getJobExecution().getJobParameters();
        System.out.println("fileName===" + parameters.getString("fileName"));
    }

    @Bean
    public FlatFileItemReader<CropInsuranceDTO> reader() {
        FlatFileItemReader<CropInsuranceDTO> reader = new FlatFileItemReader<CropInsuranceDTO>();
        reader.setResource(new ClassPathResource("DataFiles/crop_insurance.csv"));

        reader.setLineMapper(new DefaultLineMapper<CropInsuranceDTO>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"SERIALNO", "MANDALNAME", "VILLAGENAME", "NAMEOFTHEBENEFICIARY", "CROP",
                        "EXTENTHA", "CLAIMAMOUNTRS", "CATEGORYLOANEENONLOANEE",
                        "BANKNAME", "BRANCHNAME", "ACCOUNTNUMBER"});
            }});

            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(CropInsuranceDTO.class);
            }});

        }});
        reader.setLinesToSkip(1);
        return reader;
    }
}
