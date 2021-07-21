package com.web.demo.batch.process;

import com.web.demo.dtos.EmployeeDTO;
import com.web.demo.entities.Employee;
import com.web.demo.repos.EmployeeRepo;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, Employee> {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee process(final EmployeeDTO employee) throws Exception {
        //Optional<Employee> userFromDb = employeeRepository.findById(employee.getId());
        System.out.println("Transforming Employee(s) to EmployeeDTO(s)..");
        final Employee entity = new Employee(employee.getFirstName(), employee.getLastName(),
                employee.getCompanyName(), employee.getAddress(), employee.getCity(), employee.getCounty(), employee.getState()
                , employee.getZip());

        return entity;
    }
}
