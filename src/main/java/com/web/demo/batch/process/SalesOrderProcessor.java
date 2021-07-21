package com.web.demo.batch.process;

import com.web.demo.dtos.SalesOrderDTO;
import com.web.demo.entities.SalesOrder;
import com.web.demo.repos.SalesOrderRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class SalesOrderProcessor implements ItemProcessor<SalesOrderDTO, SalesOrder> {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Override
    public SalesOrder process(final SalesOrderDTO saleDto) throws Exception {
        //Optional<Employee> userFromDb = employeeRepository.findById(employee.getId());

        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = format.parse(saleDto.getOrderDate());

        final SalesOrder salesOrder = new SalesOrder();
        salesOrder.setRegion(saleDto.getRegion());
        salesOrder.setCountry(saleDto.getCountry());
        salesOrder.setItemType(saleDto.getItemType());
        salesOrder.setSalesChannel(saleDto.getSalesChannel());
        salesOrder.setOrderPriority(saleDto.getOrderPriority());
        salesOrder.setOrderDate(date);
        salesOrder.setOrderId(Long.valueOf(saleDto.getOrderId()));
        date = format.parse(saleDto.getShipDate());
        salesOrder.setShipDate(date);
        salesOrder.setUnitSold(Integer.valueOf(saleDto.getUnitSold()));
        salesOrder.setUnitPrice(Double.valueOf(saleDto.getUnitPrice()));
        salesOrder.setUnitCost(Double.valueOf(saleDto.getUnitCost()));
        salesOrder.setTotalRevenue(Double.valueOf(saleDto.getTotalRevenue()));
        salesOrder.setTotalCost(Double.valueOf(saleDto.getTotalCost()));
        salesOrder.setTotalProfit(Double.valueOf(saleDto.getTotalProfit()));
        //System.out.println("Transforming SalesOrder(s) to SalesOrderDTO(s).." + salesOrder.getShipDate());
        return salesOrder;
    }
}
