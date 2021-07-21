package com.web.demo.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import com.web.demo.dtos.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ReadCSVFiles {
    public static String fileBefore = "D:/DataFiles/Downloaded/";

    public static void main(String[] args) {
        /* List<CropInsuranceDTO> cropDetails = readCropDetails("csv/crop_insurance.csv"); */
        /*List<StudentDTO> studentInfo = readStudentInfo("csv/StudentInfo.csv");*/
        /* List<EmployeeDTO> employeeInfo = readEmployeeInfo("csv/employee.csv");*/
        //List<CropInsuranceDTO> hrDetails = readHRDetails("csv/50000_HR_Records.csv");
        /* List<Countries> countriesRegions = readCountriesRegions("csv/CountriesRegions.csv");*/
        //synchronousMethods();
        asynchronousMethods();
        /*try {
            getCompletableFutures();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private static void getCompletableFutures() throws Exception {
        CompletableFuture<CropInsuranceDTO> futureDto = CompletableFuture.supplyAsync(() -> getCropDetail());
        CompletableFuture<List<CropInsuranceDTO>> futureList = CompletableFuture.supplyAsync(() -> getCropDetailList());
        System.out.println("Crop Detail===" + futureDto.get().getBankName());
        System.out.println("Crop Detail List===" + futureList.get().get(0).getBankName());
    }

    private static void asynchronousMethods() {
        long startTime = System.currentTimeMillis();
        CompletableFuture<List<CropInsuranceDTO>> cropFuture = CompletableFuture.supplyAsync(() -> readCropDetails("csv/crop_insurance.csv"));
        CompletableFuture<List<StudentDTO>> studentFuture = CompletableFuture.supplyAsync(() -> readStudentInfo("csv/StudentInfo.csv"));
        CompletableFuture<List<EmployeeDTO>> empFuture = CompletableFuture.supplyAsync(() -> readEmployeeInfo("csv/employee.csv"));
        CompletableFuture<List<CountriesDTO>> countriesFuture = CompletableFuture.supplyAsync(() -> readCountriesRegions("csv/CountriesRegions.csv"));
        CompletableFuture<List<SalesOrderDTO>> salesFuture = CompletableFuture.supplyAsync(() -> readSalesOrderDetails("csv/100000_Sales_Order.csv"));
        CompletableFuture.allOf(cropFuture, studentFuture, empFuture, countriesFuture, salesFuture);
        try {
            List<CropInsuranceDTO> cropList = cropFuture.get();
            List<StudentDTO> stdList = studentFuture.get();
            List<EmployeeDTO> empList = empFuture.get();
            List<CountriesDTO> contList = countriesFuture.get();
            List<SalesOrderDTO> saleList = salesFuture.get();
            System.out.println("CropSize==" + cropList.size());
            System.out.println("StudentSize==" + stdList.size());
            System.out.println("EmpSize==" + empList.size());
            System.out.println("CountrySize==" + contList.size());
            System.out.println("SalesSize===" + saleList.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken===" + (endTime - startTime));
    }

    private static void synchronousMethods() {
        long startTime = System.currentTimeMillis();
        List<CropInsuranceDTO> cropDetails = readCropDetails("csv/crop_insurance.csv");
        List<StudentDTO> studentInfo = readStudentInfo("csv/StudentInfo.csv");
        List<EmployeeDTO> employeeInfo = readEmployeeInfo("csv/employee.csv");
        List<CountriesDTO> countriesRegions = readCountriesRegions("csv/CountriesRegions.csv");
        List<SalesOrderDTO> salesOrderDetails = readSalesOrderDetails("csv/100000_Sales_Order.csv");
        System.out.println("salesOrderDetails===" + salesOrderDetails.size());
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken===" + (endTime - startTime));
    }

    private static List<CropInsuranceDTO> getCropDetailList() {
        CropInsuranceDTO dto = new CropInsuranceDTO();
        dto.setBankName("SBI");
        List<CropInsuranceDTO> dtoList = new ArrayList<>();
        dtoList.add(dto);
        return dtoList;
    }


    public static CropInsuranceDTO getCropDetail() {
        CropInsuranceDTO dto = new CropInsuranceDTO();
        dto.setBankName("SBI");
        return dto;
    }

    public static List<CropInsuranceDTO> readCropDetails(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CropInsuranceDTO> listCrop = null;
        try {
            TimeUnit.SECONDS.sleep(2);
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(CropInsuranceDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    public static List<StudentDTO> readStudentInfo(String fileAfter) {
        List<StudentDTO> listCrop = null;
        try {
            TimeUnit.SECONDS.sleep(2);
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(StudentDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    public static List<EmployeeDTO> readEmployeeInfo(String fileAfter) {
        List<EmployeeDTO> listCrop = null;
        try {
            TimeUnit.SECONDS.sleep(2);
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(EmployeeDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    public static List<CountriesDTO> readCountriesRegions(String fileAfter) {
        List<CountriesDTO> listCrop = null;
        try {
            TimeUnit.SECONDS.sleep(2);
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(CountriesDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    public static List<SalesOrderDTO> readSalesOrderDetails(String fileAfter) {
        List<SalesOrderDTO> listCrop = null;
        try {
            TimeUnit.SECONDS.sleep(2);
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(SalesOrderDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    private static List<CropInsuranceDTO> readHRDetails(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CropInsuranceDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(CropInsuranceDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}

