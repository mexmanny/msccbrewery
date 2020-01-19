package spring.project.msccbrewery.services;

import spring.project.msccbrewery.web.model.CustomerDTO;

import java.util.UUID;


public interface CustomerService {
    CustomerDTO getCustomerId(UUID customerId);
    CustomerDTO saveNewCustomer(CustomerDTO customerDTO);
    void updateCustomerId(UUID uuid, CustomerDTO customerDTO);
    void deleteByCustomerId(UUID customerId);
}
