package com.web.demo.services;

import com.web.demo.async.*;
import com.web.demo.dtos.*;
import com.web.demo.utils.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.web.demo.utils.ExecutorServiceUtil.getTheExecutorService;
import static java.util.Comparator.comparing;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Service
public class CSVReadServiceImpl implements CSVReadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVReadServiceImpl.class);

    @Autowired
    private ResourceLoader resourceLoader;


    @Override
    public List<IndiaStatesDTO> getIndiaStates() {
        CompletableFuture<List<IndiaStatesDTO>> empFuture = supplyAsync(new ReadIndiaStatesSupplier(), getTheExecutorService());
        List<IndiaStatesDTO> empList = null;
        try {
            empList = empFuture.get();
            empList = Optional.ofNullable(empList)
                    .orElseGet(Collections::emptyList)
                    .parallelStream()
                    .filter(Objects::nonNull)
                    .filter(f -> !f.getStateName().contains("&"))
                    .filter(f -> f.getStateName() != null && f.getStateName().equalsIgnoreCase("HARYANA"))
                    .collect(Collectors.toList());
            return empList;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CropInsuranceDTO> readCropDetailsByMandal(String mandal) {
        CompletableFuture<List<CropInsuranceDTO>> cropFuture = supplyAsync(new ReadCropInsuranceSupplier());
        try {
            return Optional.ofNullable(cropFuture.get())
                    .orElseGet(Collections::emptyList)
                    .parallelStream()
                    .filter(Objects::nonNull)
                    .filter(f -> f.getMandalName().equalsIgnoreCase(mandal))
                    .collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<IndiaStatesDTO> getIndiaStatesByState(String state) {
        CompletableFuture<List<IndiaStatesDTO>> empFuture =
                supplyAsync(new ReadIndiaStatesSupplier(), getTheExecutorService());
        List<IndiaStatesDTO> empList = null;
        //ANDHRA PRADESH
        try {
            empList = empFuture.get();
            return Optional.ofNullable(empList)
                    .orElseGet(Collections::emptyList)
                    .parallelStream()
                    .filter(Objects::nonNull)
                    .filter(x -> x.getStateName().equalsIgnoreCase(state))
                    .collect(Collectors.toList());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeeDTO> readEmployeeInfo() {
        CompletableFuture<List<EmployeeDTO>> empFuture = supplyAsync(new ReadEmployeeSupplier());
        List<EmployeeDTO> empList = null;
        try {
            TimeUnit.SECONDS.sleep(10);
            return empFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CropInsuranceDTO> readCropDetails() {
        CompletableFuture<List<CropInsuranceDTO>> cropFuture = supplyAsync(new ReadCropInsuranceSupplier());
        try {
            return cropFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<StudentDTO> readStudentInfo() {
        CompletableFuture<List<StudentDTO>> cropFuture = supplyAsync(new ReadStudentSupplier());
        try {
            return Optional.ofNullable(cropFuture.get())
                    .orElseGet(Collections::emptyList)
                    .parallelStream()
                    .sorted(comparing(StudentDTO::getStudentId))
                    .collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CountriesDTO> readCountriesRegions() {
        CompletableFuture<List<CountriesDTO>> cropFuture = supplyAsync(new ReadCountriesSupplier());
        try {
            return cropFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SalesOrderDTO> readSalesOrderDetails() {
        CompletableFuture<List<SalesOrderDTO>> cropFuture = supplyAsync(new ReadSalesOrderSupplier());
        try {
            return cropFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CropInsuranceDTO> readCropInsuranceCSV() {
        Resource resource = resourceLoader.getResource("classpath:DataFiles/crop_insurance.csv");
        File file = null;
        try {
            file = resource.getFile();
            InputStream input = resource.getInputStream();
            List<CropInsuranceDTO> crops = CSVHelper.csvToCropInsurance(input);
            return crops;
        } catch (Exception e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
