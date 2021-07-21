package com.web.demo.utils;

import com.web.demo.dtos.CropInsuranceDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Id", "Title", "Description", "Published"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<CropInsuranceDTO> csvToCropInsurance(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<CropInsuranceDTO> crops = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            Optional<String> stringOpt = Optional.empty();
            for (CSVRecord csvRecord : csvRecords) {
                // Long.parseLong(csvRecord.get("Id")),
                //Boolean.parseBoolean(csvRecord.get("Published")
                CropInsuranceDTO crop = new CropInsuranceDTO();
                crop.setSerialNumber(Integer.parseInt(csvRecord.get("SERIALNO")));
                crop.setMandalName(csvRecord.get("MANDALNAME"));
                crop.setVillageName(csvRecord.get("VILLAGENAME"));
                crop.setNameOfTheBeneficiary(csvRecord.get("NAMEOFTHEBENEFICIARY"));
                crop.setCrop(csvRecord.get("CROP"));
                //crop.setExtentHa(csvRecord.get("EXTENTHA"));
                //crop.setClaimAmountRs(csvRecord.get("CLAIMAMOUNTRS"));
                stringOpt = Optional.ofNullable(csvRecord.get("EXTENTHA")).filter(f -> null != f && f.trim().length() > 0);
                if (stringOpt.isPresent()) {
                    double d = Double.parseDouble(stringOpt.get());
                    int i = (int) d;
                    crop.setExtentHa(i);
                }
                stringOpt = Optional.ofNullable(csvRecord.get("CLAIMAMOUNTRS")).filter(f -> null != f && f.trim().length() > 0);
                if (stringOpt.isPresent()) {
                    double d = Double.parseDouble(stringOpt.get());
                    int i = (int) d;
                    crop.setClaimAmountRs(i);
                }
                crop.setCategoryLoaneeNonLoanee(csvRecord.get("CATEGORYLOANEENONLOANEE"));
                crop.setBankName(csvRecord.get("BANKNAME"));
                crop.setBranchName(csvRecord.get("BRANCHNAME"));
                crop.setAccountNumber(csvRecord.get("ACCOUNTNUMBER"));

                crops.add(crop);
            }

            return crops;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
