package com.northwind.np.dto;

import com.northwind.np.entities.EmployeeEntity;

public class EmployeeDTO {

    private Integer employeeId;
    private String title;
    private String fName;
    private String lName;
    private String companyTitle;
    private String city;
    private String country;

    public EmployeeDTO(EmployeeEntity employeeEntity) {
        this.employeeId = employeeEntity.getId();
        this.title = employeeEntity.getTitleOfCourtesy();
        this.fName = employeeEntity.getFirstName();
        this.lName = employeeEntity.getLastName();
        this.companyTitle = employeeEntity.getTitle();
        this.city = employeeEntity.getCity();
        this.country = employeeEntity.getCountry();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getTitle() {
        return title;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
