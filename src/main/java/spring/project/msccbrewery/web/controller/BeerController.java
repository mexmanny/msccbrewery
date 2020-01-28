package spring.project.msccbrewery.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spring.project.msccbrewery.services.BeerService;
import spring.project.msccbrewery.web.client.BreweryClient;
import spring.project.msccbrewery.web.model.BeerDto;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController //includes repsonse body and controller
public class BeerController {

    @Value("${sfg.brewery.apiHost}")
    String apiHost;

    @Autowired
    private final BeerService beerService;
    @Autowired
   BreweryClient breweryClient;

    public BeerController (BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer (@PathVariable ("beerId")UUID beerId) {

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer (@RequestBody BeerDto beerDto) {
        BeerDto saveDto = beerService.saveNewBeer(beerDto);

       HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url

        breweryClient.setApiHost(apiHost);

       headers.add("Location", "/api/v1/beer/" + saveDto.getId().toString()) ;

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeerById(@PathVariable ("beerId")UUID beerId, @RequestBody BeerDto beerDto) {

        //beerService.updateBeer(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping ({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer (@PathVariable UUID beerId) {
      //  beerService.deleteById(beerId);

    }

}
