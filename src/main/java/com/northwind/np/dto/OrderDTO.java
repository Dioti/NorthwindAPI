package com.northwind.np.dto;

import com.northwind.np.entities.OrderEntity;

import java.math.BigDecimal;
import java.time.Instant;

public class OrderDTO {
    private int orderID;
    private String customerId;
    private int employeeId;
    private Instant orderDate;
    private Instant shipDate;
    private BigDecimal freight;
    private String shipCompanyName;
    private String shipCountry, shipRegion;

    public OrderDTO(OrderEntity orderEntity) {
        this.orderID = orderEntity.getId();
        this.customerId = orderEntity.getCustomerID().getId();
        this.employeeId = orderEntity.getEmployeeID().getId();
        this.orderDate = orderEntity.getOrderDate();
        this.shipDate = orderEntity.getShippedDate();
        this.freight = orderEntity.getFreight();
        this.shipCompanyName = orderEntity.getShipName();
        this.shipCountry = orderEntity.getShipCountry();
        this.shipRegion = orderEntity.getShipRegion();
    }

    public int getOrderID() {
        return orderID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public Instant getShipDate() {
        return shipDate;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public String getShipCompanyName() {
        return shipCompanyName;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public String getShipRegion() {
        return shipRegion;
    }
}
