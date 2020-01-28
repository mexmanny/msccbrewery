package spring.project.msccbrewery.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.project.msccbrewery.web.model.BeerDto;
import spring.project.msccbrewery.web.model.CustomerDTO;


import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {

        BeerDto dto = client.getBeerById(UUID.randomUUID());


        assertNotNull(dto);

    }



   @Test
  void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("Kenzinger").build();
        URI uri = client.saveNewBeer(beerDto);

       assertNotNull(uri);

        System.out.println(uri);


    }


    @Test
    void testUpdateNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("Kenzinger").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }


    @Test
    void testDeleteBeer() {

        client.deleteBeer(UUID.randomUUID());

    }


    @Test
    void getCustomerById () {
        CustomerDTO customerDTO =client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDTO);
    }


    @Test
    void testSaveCustomerClient () {
        CustomerDTO customerDto = CustomerDTO.builder().name("Bob Sanchez").build();

        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);


    }



}