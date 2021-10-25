package com.northwind.np.services;

import com.northwind.np.dto.EmployeeDTO;
import com.northwind.np.entities.EmployeeEntity;
import com.northwind.np.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployeeDTO() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesById(Integer employeeId) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getId().equals(employeeId))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByFirstName(String firstName) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByLastName(String lastName) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByCountry(String country) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByFirstNameAndCountry(String firstName, String country) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByLastNameAndCountry(String lastName, String country) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByFirstAndLastName(String firstName, String lastName) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertEmployeeEntityToEmployeeDTO(EmployeeEntity employeeEntity) {
        return new EmployeeDTO(employeeEntity);
    }
}
