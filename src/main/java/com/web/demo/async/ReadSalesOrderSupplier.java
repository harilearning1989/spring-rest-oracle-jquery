package com.web.demo.async;

import com.web.demo.dtos.SalesOrderDTO;
import com.opencsv.bean.CsvToBeanBuilder;
import com.web.demo.utils.DownloadGitHubFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class ReadSalesOrderSupplier implements Supplier<List<SalesOrderDTO>> {
    @Override
    public List<SalesOrderDTO> get() {
        String file = "csv/SalesOrder.csv";
        try {
            DownloadGitHubFiles.downloadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<SalesOrderDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/" + file))
                    .withType(SalesOrderDTO.class)
                    .build()
                    .parse();
            listCrop = Optional.ofNullable(listCrop)
                    .orElseGet(Collections::emptyList)
                    .parallelStream()
                    .filter(Objects::nonNull)
                    //.filter(f -> f.getOrderPriority().equalsIgnoreCase("h"))
                    .sorted(comparing(SalesOrderDTO::getSalesId))
                    .collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
