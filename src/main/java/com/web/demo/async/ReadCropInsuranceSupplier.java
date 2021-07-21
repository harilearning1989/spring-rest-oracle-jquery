package com.web.demo.async;

import com.opencsv.bean.CsvToBeanBuilder;
import com.web.demo.dtos.CropInsuranceDTO;
import com.web.demo.utils.CommonUtils;
import com.web.demo.utils.DownloadGitHubFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Supplier;

public class ReadCropInsuranceSupplier implements Supplier<List<CropInsuranceDTO>> {
    @Override
    public List<CropInsuranceDTO> get() {
        String file = "csv/crop_insurance.csv";
        try {
            DownloadGitHubFiles.downloadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CropInsuranceDTO> listCrop = null;
        try {
            if (CommonUtils.isWindows()) {
                file = "D:/DataFiles/Downloaded/" + file;
            } else if (CommonUtils.isLinux()) {
                file = "/tmp/Downloaded/" + file;
            }
            listCrop = new CsvToBeanBuilder(new FileReader(file))
                    .withType(CropInsuranceDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
