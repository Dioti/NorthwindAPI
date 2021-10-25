package com.northwind.np.dto;

import com.northwind.np.entities.SupplierEntity;

public class SupplierDTO {
    private int supplierID;
    private String companyName, contactName, contactTitle;
    private String address, city, region, postalCode, country;
    private String phone, fax;

    public SupplierDTO(SupplierEntity supplierEntity) {
        supplierID = supplierEntity.getId();
        companyName = supplierEntity.getCompanyName();
        contactName = supplierEntity.getContactName();
        contactTitle = supplierEntity.getContactTitle();
        address = supplierEntity.getAddress();
        city = supplierEntity.getCity();
        region = supplierEntity.getRegion();
        postalCode = supplierEntity.getPostalCode();
        country = supplierEntity.getCountry();
        phone = supplierEntity.getPhone();
        fax = supplierEntity.getFax();
    }

    public int getSupplierID() {
        return supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }
}
