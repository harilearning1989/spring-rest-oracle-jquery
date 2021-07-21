package com.web.demo.batch.write;

import com.web.demo.entities.SalesOrder;
import com.web.demo.repos.SalesOrderRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class SalesOrderWriter implements ItemWriter<SalesOrder> {

    @Autowired
    private SalesOrderRepository repo;

    @Override
    @Transactional
    public void write(List<? extends SalesOrder> users) throws Exception {
        repo.saveAll(users);
    }
}
