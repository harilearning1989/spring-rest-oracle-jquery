package com.web.demo.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SALES_ORDER")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "in_only_test_sale",
                procedureName = "test_pkg.in_only_test",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "in_and_out_test_sale",
                procedureName = "test_pkg.in_and_out_test",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam1", type = String.class)
                })
})
public class SalesOrder {

    @Id
    @Column(name = "SALE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long salesId;
    @Column(name = "REGION")
    private String region;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Column(name = "SALES_CHANNEL")
    private String salesChannel;
    @Column(name = "ORDER_PRIORITY")
    private String orderPriority;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "ORDER_ID")
    private long orderId;
    @Column(name = "SHIP_DATE")
    private Date shipDate;
    @Column(name = "UNITS_SOLD")
    private int unitSold;
    @Column(name = "UNIT_PRICE")
    private double unitPrice;
    @Column(name = "UNIT_COST")
    private double unitCost;
    @Column(name = "TOTAL_REVENUE")
    private double totalRevenue;
    @Column(name = "TOTAL_COST")
    private double totalCost;
    @Column(name = "TOTAL_PROFIT")
    private double totalProfit;

    public long getSalesId() {
        return salesId;
    }

    public void setSalesId(long salesId) {
        this.salesId = salesId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public int getUnitSold() {
        return unitSold;
    }

    public void setUnitSold(int unitSold) {
        this.unitSold = unitSold;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

}
