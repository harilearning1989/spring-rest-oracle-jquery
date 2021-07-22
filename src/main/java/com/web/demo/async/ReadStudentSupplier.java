package com.web.demo.async;

import com.web.demo.dtos.StudentDTO;
import com.opencsv.bean.CsvToBeanBuilder;
import com.web.demo.utils.DownloadGitHubFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Supplier;

public class ReadStudentSupplier implements Supplier<List<StudentDTO>> {
    @Override
    public List<StudentDTO> get() {
        String file = "csv/StudentInfo.csv";
        try {
            DownloadGitHubFiles.downloadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<StudentDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/" + file))
                    .withType(StudentDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
