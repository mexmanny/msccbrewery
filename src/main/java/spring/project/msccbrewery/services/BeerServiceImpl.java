package spring.project.msccbrewery.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.project.msccbrewery.web.model.BeerDto;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    public void updateBeer (UUID beerId, BeerDto beerDto) {
        //todo imp - would add a real imp to update beer
    }

    public void deleteById (UUID beerId) {
        log.debug("Deleting a beer ...") ;
    }
}
