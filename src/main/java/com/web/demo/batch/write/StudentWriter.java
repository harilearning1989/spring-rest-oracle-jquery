package com.web.demo.batch.write;

import com.web.demo.entities.Student;
import com.web.demo.repos.StudentRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StudentWriter implements ItemWriter<Student> {

    @Autowired
    private StudentRepository repo;

    @Override
    @Transactional
    public void write(List<? extends Student> users) throws Exception {
        repo.saveAll(users);
    }
}