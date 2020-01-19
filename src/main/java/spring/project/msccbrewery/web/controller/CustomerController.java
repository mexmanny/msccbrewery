package spring.project.msccbrewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @PostMapping ({"/api/v1/customer/"})
    public  ResponseEntity handleCustomerPost (@RequestBody CustomerDTO customerDto)

    {

        CustomerDTO saveCustomerDTO = customerservice.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("location","/api/v1/customer/" + saveCustomerDTO.getCustomerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping ({"/api/v1/customer/{customerId}"})
    public ResponseEntity handleUpdate (@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDTO)
    {
        customerservice.updateCustomerId (customerId, customerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/api/v1/customer/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId")UUID customerId) {
        customerservice.deleteByCustomerId(customerId);


    }



}
