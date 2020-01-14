package spring.project.msccbrewery.services;

import spring.project.msccbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);
}