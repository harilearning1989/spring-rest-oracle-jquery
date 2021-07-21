package com.web.demo.services;

import com.web.demo.dtos.*;

import java.util.List;

public interface AsyncService {
    List<CropInsuranceDTO> readCropDetails(String s);

    List<StudentDTO> readStudentInfo(String s);

    List<EmployeeDTO> readEmployeeInfo(String s);

    List<CountriesDTO> readCountriesRegions(String s);

    List<SalesOrderDTO> readSalesOrderDetails(String s);
}
