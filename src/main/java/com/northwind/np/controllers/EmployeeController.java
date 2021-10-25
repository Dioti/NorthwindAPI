package com.northwind.np.controllers;

import com.northwind.np.dto.EmployeeDTO;
import com.northwind.np.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/northwind/employees")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployeeDTO();
    }

    @GetMapping(value="/northwind/employees", params={"employeeId"})
    public List<EmployeeDTO> getEmployeesByEmployeeId(@RequestParam Integer employeeId) {
        return employeeService.getEmployeesById(employeeId);
    }

    @GetMapping(value="/northwind/employees", params={"firstName"})
    public List<EmployeeDTO> getEmployeesByFirstName(@RequestParam String firstName) {
        return employeeService.getEmployeesByFirstName(firstName);
    }

    @GetMapping(value="/northwind/employees", params={"lastName"})
    public List<EmployeeDTO> getEmployeesByLastName(@RequestParam String lastName) {
        return employeeService.getEmployeesByLastName(lastName);
    }

    @GetMapping(value="/northwind/employees", params={"country"})
    public List<EmployeeDTO> getEmployeesByCountry(@RequestParam String country) {
        return employeeService.getEmployeesByCountry(country);
    }

    @GetMapping(value="/northwind/employees", params={"firstName", "country"})
    public List<EmployeeDTO> getEmployeesByFirstNameAndCountry(@RequestParam String firstName,
                                                               @RequestParam String country) {
        return employeeService.getEmployeesByFirstNameAndCountry(firstName, country);
    }

    @GetMapping(value="/northwind/employees", params={"lastName", "country"})
    public List<EmployeeDTO> getEmployeesByLastNameAndCountry(@RequestParam String lastName,
                                                              @RequestParam String country) {
        return employeeService.getEmployeesByLastNameAndCountry(lastName, country);
    }

    @GetMapping(value="/northwind/employees", params={"firstName", "lastName"})
    public List<EmployeeDTO> getEmployeesByFirstAndLastName(@RequestParam String firstName,
                                                            @RequestParam String lastName) {
        return employeeService.getEmployeesByFirstAndLastName(firstName, lastName);
    }
}
