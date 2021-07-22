package com.web.demo.async;

import com.web.demo.dtos.EmployeeDTO;
import com.opencsv.bean.CsvToBeanBuilder;
import com.web.demo.utils.DownloadGitHubFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class ReadEmployeeSupplier implements Supplier<List<EmployeeDTO>> {
    @Override
    public List<EmployeeDTO> get() {
        String file = "csv/employee.csv";
        try {
            DownloadGitHubFiles.downloadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<EmployeeDTO> listCrop = null;
        try {
            TimeUnit.SECONDS.sleep(2);
            listCrop = new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/" + file))
                    .withType(EmployeeDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
