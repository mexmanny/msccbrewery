package spring.project.msccbrewery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import spring.project.msccbrewery.domain.Beer;

import java.util.UUID;


public interface BeerRepository extends PagingAndSortingRepository <Beer, UUID> {


}
