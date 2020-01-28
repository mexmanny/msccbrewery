package spring.project.msccbrewery.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.project.msccbrewery.web.model.BeerDto;
import spring.project.msccbrewery.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.customer", ignoreUnknownFields = false)
public class CustomerClient {

    String customerApiHost;

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer";





    private final RestTemplate restTemplate; //spring injects rest template



public CustomerClient (RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
}







}
