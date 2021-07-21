package com.web.demo.async;

import com.opencsv.bean.CsvToBeanBuilder;
import com.web.demo.dtos.CropInsuranceDTO;
import com.web.demo.utils.DownloadGitHubFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Supplier;

public class ReadCropInsuranceSupplier implements Supplier<List<CropInsuranceDTO>> {
    @Override
    public List<CropInsuranceDTO> get() {
        try {
            DownloadGitHubFiles.downloadFile("csv/crop_insurance.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CropInsuranceDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/csv/crop_insurance.csv"))
                    .withType(CropInsuranceDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
