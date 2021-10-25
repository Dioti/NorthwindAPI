package com.northwind.np.controllers;

import com.northwind.np.dto.SupplierDTO;
import com.northwind.np.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/northwind/supplier/{supplierID}")
    public List<SupplierDTO> getSupplierByID(@PathVariable Optional<Integer> supplierID) {
        if (supplierID.isPresent())
            return supplierService.getAllSupplierDTO();
        else return null;
    }

    @GetMapping("/northwind/supplier")
    public List<SupplierDTO> sortSuppliersByRegionCountryCity(
            @RequestParam String country, @RequestParam(required = false) String city,
            @RequestParam(required = false) String postCode) {

        List<SupplierDTO> suppliers = new ArrayList();

        if (city == null && postCode == null) {
            for (SupplierDTO s : supplierService.getAllSupplierDTO()) {
                if (s.getCountry() != null && s.getCountry().equals(country)) {
                    suppliers.add(s);
                }
            }
        } else if (city != null && postCode == null) {
            for (SupplierDTO s : supplierService.getAllSupplierDTO()) {
                if (s.getCity() != null && s.getCountry() != null) {
                    if (s.getCountry().equals(country) && s.getCity().equals(city)) {
                        suppliers.add(s);
                    }
                }
            }
        } else if (city == null) {
            for (SupplierDTO s : supplierService.getAllSupplierDTO()) {
                if (s.getPostalCode() != null && s.getCountry() != null) {
                    if (s.getCountry().equals(country) && s.getPostalCode().equals(postCode)) {
                        suppliers.add(s);
                    }
                }
            }
        } else {
            for (SupplierDTO s : supplierService.getAllSupplierDTO()) {
                if (s.getPostalCode() != null && s.getCity() != null && s.getPostalCode() != null) {
                    if (s.getCountry().equals(country) && s.getCity().equals(city)
                            && s.getPostalCode().equals(postCode)) {
                        suppliers.add(s);
                    }
                }
            }
        }
        return suppliers;
    }

    //TODO: change return type to optional maybe? depends if companyName is unique or not
    @GetMapping(value = "/northwind/suppliers", params = {"name"})
    public List<SupplierDTO> getSuppliersWithCompanyName(@RequestParam String name) {
        List<SupplierDTO> suppliers = new ArrayList<>();

        for (SupplierDTO s : supplierService.getAllSupplierDTO()) {
            if (s.getCompanyName() != null && s.getCompanyName().equals(name)) {
                suppliers.add(s);
            }
        }

        return suppliers;
    }

    @GetMapping("/northwind/suppliers")
    public List<SupplierDTO> getAllSuppliers() {
        return supplierService.getAllSupplierDTO();
    }

}
