package spring.project.msccbrewery.services;

import org.springframework.stereotype.Service;
import spring.project.msccbrewery.web.model.BeerDto;

import java.util.UUID;
@Service
public interface BeerService {

    BeerDto getBeerById(UUID beerId);


    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeerById (UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);


}