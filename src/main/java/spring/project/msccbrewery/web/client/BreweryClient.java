package spring.project.msccbrewery.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.project.msccbrewery.web.model.BeerDto;
import spring.project.msccbrewery.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    public String apiHost;


    private final RestTemplate restTemplate; //spring injects rest template

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(),BeerDto.class);
    }

    public URI saveNewBeer (BeerDto beerDto) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }


    public void updateBeer(UUID uuid, BeerDto beerDto) {
        restTemplate.put(apiHost+BEER_PATH_V1+ "/" + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apiHost+BEER_PATH_V1+ "/" + uuid);
    }


    public CustomerDTO getCustomerById (UUID uuid) {
        return  restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDTO.class);
    }

    public URI saveNewCustomer(CustomerDTO customerDTO) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDTO);
    }

    public void  updateCustomer(UUID uuid, CustomerDTO customerDTO) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + "/" +uuid.toString(), customerDTO);

    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apiHost +CUSTOMER_PATH_V1 + "/" + uuid);
    }

}
