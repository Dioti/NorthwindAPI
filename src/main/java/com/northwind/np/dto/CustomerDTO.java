package com.northwind.np.dto;

import com.northwind.np.entities.CustomerEntity;

public class CustomerDTO {
    private String contactName;
    private String companyName;
    private String contactTitle;
    private String city, region;
    private String country;
    private String id;

    public CustomerDTO(CustomerEntity customerEntity) {
        contactName = customerEntity.getContactName();
        companyName = customerEntity.getCompanyName();
        contactTitle = customerEntity.getContactTitle();
        city = customerEntity.getCity();
        id = customerEntity.getId();
        region = customerEntity.getRegion();
        country = customerEntity.getCountry();
    }

    public String getContactName() {
        return contactName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }
}
