package com.northwind.np.services;

import com.northwind.np.dto.CustomerDTO;
import com.northwind.np.entities.CustomerEntity;
import com.northwind.np.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomerDTO() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> getCustomersByName(String name) {
        return customerRepository.findAll()
                .stream()
                .filter(customerDTO -> customerDTO.getContactName().contains(name))
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> getCustomersByCountry(String country) {
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getCountry().contains(country))
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> getCustomersByNameAndCountry(String name, String country) {
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getContactName().contains(name))
                .filter(customerEntity -> customerEntity.getCountry().contains(country))
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> getCustomersById(String customerId) {
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getId().equals(customerId))
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    private CustomerDTO convertCustomerEntityToCustomerDTO(CustomerEntity customer) {
        return new CustomerDTO(customer);
    }
}
