package com.northwind.np.dto;

import com.northwind.np.entities.ShipperEntity;

public class ShipperDTO {
    private Integer shipperID;
    private String companyName, phone;

    public ShipperDTO(ShipperEntity shipperEntity) {
        shipperID = shipperEntity.getId();
        companyName = shipperEntity.getCompanyName();
        phone = shipperEntity.getPhone();
    }

    public Integer getShipperID() {
        return shipperID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhone() {
        return phone;
    }
}
