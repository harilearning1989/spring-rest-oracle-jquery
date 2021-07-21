package com.web.demo.batch.process;

import com.web.demo.dtos.StudentDTO;
import com.web.demo.entities.Student;
import com.web.demo.repos.StudentRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentProcessor implements ItemProcessor<StudentDTO, Student> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student process(final StudentDTO dto) throws Exception {
        //Optional<Employee> userFromDb = employeeRepository.findById(employee.getId());

        final Student student = new Student();
        student.setStudentId(dto.getStudentId());
        student.setStudentName(dto.getStudentName());
        student.setFatherName(dto.getFatherName());
        student.setGender(dto.getGender());
        student.setMobile(Long.parseLong(dto.getMobile()));
        student.setCategory(dto.getCategory());
        return student;
    }
}
