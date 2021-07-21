package com.web.demo.controls;

import com.web.demo.dtos.*;
import com.web.demo.response.AjaxResponseBody;
import com.web.demo.services.AsyncService;
import com.web.demo.services.CSVReadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping("csv")
@Api(value = "CSVReadRestController")
public class CSVReadRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVReadRestController.class);

    AsyncService asyncService;

    @Autowired
    public void setAsyncService(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    CSVReadService csvReadService;

    @Autowired
    public void setCSVReadService(CSVReadService csvReadService) {
        this.csvReadService = csvReadService;
    }

    @Value("${csv.read.readCsv}")
    private String load;

    @GetMapping(value = "/states")
    public List<IndiaStatesDTO> getIndiaStates() {
        CompletableFuture<List<IndiaStatesDTO>> empFuture =
                supplyAsync(() -> csvReadService.getIndiaStates());
        try {
            return empFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/byMandal")
    public ResponseEntity<?> getSearchResultViaAjax(
            @Valid @RequestBody SearchCriteriaDTO search, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }

        List<CropInsuranceDTO> users = csvReadService.readCropDetailsByMandal(search.getMandal());
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);

    }

    @GetMapping(value = "/readEmp")
    public List<EmployeeDTO> readEmpCSV() {
        CompletableFuture<List<EmployeeDTO>> empFuture =
                supplyAsync(() -> csvReadService.readEmployeeInfo());
        try {
            return empFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/readCrop")
    public ResponseEntity<List<CropInsuranceDTO>> readCropCSV() {
        CompletableFuture<List<CropInsuranceDTO>> cropFuture =
                supplyAsync(() -> csvReadService.readCropDetails());
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cropFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/readStudent")
    public List<StudentDTO> readStudentCSV() {
        CompletableFuture<List<StudentDTO>> studentFuture =
                supplyAsync(() -> csvReadService.readStudentInfo());
        try {
            return studentFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/readCountry")
    public List<CountriesDTO> readCountryCSV() {
        CompletableFuture<List<CountriesDTO>> countriesFuture =
                supplyAsync(() -> csvReadService.readCountriesRegions());
        try {
            return countriesFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping(value = "/readSales")
    public List<SalesOrderDTO> readSalesCSV() {
        CompletableFuture<List<SalesOrderDTO>> salesFuture =
                supplyAsync(() -> csvReadService.readSalesOrderDetails());
        try {
            return salesFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "Read All CSV Files")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/readAll")
    public void readAllCSVFiles() {
        long startTime = System.currentTimeMillis();
        CompletableFuture<List<CropInsuranceDTO>> cropFuture =
                supplyAsync(() -> asyncService.readCropDetails("csv/crop_insurance.csv"));
        CompletableFuture<List<StudentDTO>> studentFuture =
                supplyAsync(() -> asyncService.readStudentInfo("csv/StudentInfo.csv"));
        //CompletableFuture<List<EmployeeDTO>> empFuture = supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"));
        CompletableFuture<List<CountriesDTO>> countriesFuture =
                supplyAsync(() -> asyncService.readCountriesRegions("csv/CountriesRegions.csv"));
        CompletableFuture<List<SalesOrderDTO>> salesFuture =
                supplyAsync(() -> asyncService.readSalesOrderDetails("csv/100000_Sales_Order.csv"));
        /*CompletableFuture<List<EmployeeDTO>> empFutureTime =
                supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"))
                        .orTimeout(2, TimeUnit.SECONDS);*/
        CompletableFuture<List<EmployeeDTO>> empFuture =
                supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"))
                        .completeOnTimeout(new ArrayList<>(), 1, TimeUnit.SECONDS);
        CompletableFuture.allOf(cropFuture, studentFuture, empFuture, countriesFuture, salesFuture);
        try {
            List<CropInsuranceDTO> cropList = cropFuture.get();
            List<StudentDTO> stdList = studentFuture.get();
            List<EmployeeDTO> empList = empFuture.get();
            List<CountriesDTO> contList = countriesFuture.get();
            List<SalesOrderDTO> saleList = salesFuture.get();
            System.out.println("CropSize==" + cropList.size() + "==StudentSize==" + stdList.size() + "==EmpSize==" + empList.size() +
                    "==CountrySize==" + contList.size() + "===SalesSize===" + saleList.size());
            long endTime = System.currentTimeMillis();
            System.out.println("===========================================");
            System.out.println("ASync Total Time Taken==" + (endTime - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
