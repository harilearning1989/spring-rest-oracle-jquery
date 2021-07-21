package com.web.demo.batch.read;

import com.web.demo.dtos.SalesOrderDTO;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class SalesOrderReader extends FlatFileItemReader<SalesOrderDTO> {

    @Bean
    public FlatFileItemReader<SalesOrderDTO> reader() {
        FlatFileItemReader<SalesOrderDTO> reader = new FlatFileItemReader<SalesOrderDTO>();
        reader.setResource(new ClassPathResource("DataFiles/500000SalesRecords.csv"));

        reader.setLineMapper(new DefaultLineMapper<SalesOrderDTO>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"Region", "Country", "Item Type", "Sales Channel", "Order Priority", "Order Date", "Order ID", "Ship Date",
                         "Units Sold", "Unit Price", "Unit Cost", "Total Revenue", "Total Cost", "Total Profit"});
            }});

            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(SalesOrderDTO.class);
            }});

        }});
        reader.setLinesToSkip(1);
        return reader;
    }
}
