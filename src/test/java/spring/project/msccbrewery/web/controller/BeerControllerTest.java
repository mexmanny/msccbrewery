package spring.project.msccbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import spring.project.msccbrewery.services.BeerService;
import spring.project.msccbrewery.web.client.BreweryClient;
import spring.project.msccbrewery.web.model.BeerDto;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @MockBean
    BreweryClient breweryClient;
   @Test
    void getBeerById() throws Exception{

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()))
                .andExpect(status().isOk());
    }


//@Test
//    void saveNewBeer() throws Exception{
//
//    BeerDto beerDto = BeerDto.builder().build();
//    String beerDtoJson = objectMapper.writeValueAsString(beerDto);
//
//    mockMvc.perform(post("/api/v1/beer/")
//            .contentType(MediaType.APP ICATION_JSON)
//            .content(beerDtoJson))
//            .andExpect(status().isCreated());
//
//    }
//
//    @Test
//    void updateBeerById() throws Exception {
//       BeerDto beerDto = BeerDto.builder().build();
//       String beerDtoJson = objectMapper.writeValueAsString(beerDto);
//
//       mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
//               .contentType(MediaType.APPLICATION_JSON)
//               .content(beerDtoJson))
//               .andExpect(status().isNoContent());
//    }



   /* @Test
    void deleteBeer() {
    }

    */


}