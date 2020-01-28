package spring.project.msccbrewery.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.project.msccbrewery.domain.Beer;
import spring.project.msccbrewery.repositories.BeerRepository;

import java.math.BigDecimal;

@Component
/* this class will run everytime spring context starts*/
public class BeerLoader implements CommandLineRunner  {
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository){
        this.beerRepository = beerRepository;
    }

    @Override
    public void run (String...args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects () {
        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(337010000001L)
                    .price(new BigDecimal(12.95))
                    .build());


        beerRepository.save(Beer.builder()
                .beerName("Tecate")
                .beerStyle("Lager")
                .quantityToBrew(200)
                .upc(337010001001L)

                .price(new BigDecimal(11.95))
                .build());
    }
        System.out.println("Loading Beers: " + beerRepository.count());

    }



}
