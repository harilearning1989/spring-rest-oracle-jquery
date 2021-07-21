package com.web.demo.services;

import com.web.demo.dtos.*;

import java.util.List;

public interface CSVReadService {

    List<EmployeeDTO> readEmployeeInfo();

    List<CropInsuranceDTO> readCropInsuranceCSV();

    List<CropInsuranceDTO> readCropDetails();

    List<StudentDTO> readStudentInfo();

    List<CountriesDTO> readCountriesRegions();

    List<SalesOrderDTO> readSalesOrderDetails();

    List<IndiaStatesDTO> getIndiaStates();

    List<IndiaStatesDTO> getIndiaStatesByState(String state);

    List<CropInsuranceDTO> readCropDetailsByMandal(String mandal);
}
