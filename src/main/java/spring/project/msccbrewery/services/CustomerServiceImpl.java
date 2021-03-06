package spring.project.msccbrewery.services;

import org.springframework.stereotype.Service;
import spring.project.msccbrewery.web.model.CustomerDTO;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO getCustomerId(UUID id) {

            return CustomerDTO.builder().customerId(UUID.randomUUID()).name("Bob Sanchez").build();


    }

    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {

        return CustomerDTO.builder().customerId(UUID.randomUUID()).build();

    }

    public void updateCustomerId(UUID customerId, CustomerDTO customerDTO) {


    }


    public void deleteByCustomerId(UUID customerId) {

    }
 }
