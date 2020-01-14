package spring.project.msccbrewery.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.project.msccbrewery.services.CustomerService;
import spring.project.msccbrewery.web.model.CustomerDTO;

import java.util.UUID;

@RestController
public class CustomerController {


    private final CustomerService customerservice;

    public CustomerController (CustomerService customerservice) {
        this.customerservice = customerservice;
    }

    @GetMapping({"/api/v1/customer/{customerId}"})
    public ResponseEntity<CustomerDTO> getCustomerId(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity <> (customerservice.getCustomerId(customerId), HttpStatus.OK);
    }

}
