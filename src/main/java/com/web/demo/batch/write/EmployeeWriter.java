package com.web.demo.batch.write;

import com.web.demo.entities.Employee;
import com.web.demo.repos.EmployeeRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EmployeeWriter implements ItemWriter<Employee> {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    @Transactional
    public void write(List<? extends Employee> users) throws Exception {
        employeeRepo.saveAll(users);
    }
}
