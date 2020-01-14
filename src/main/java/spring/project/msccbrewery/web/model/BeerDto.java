package spring.project.msccbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data // is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode, @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder //Lombok creates a builder for all instance fields in that class.
public class BeerDto {

    private UUID id ;
    private String beerName;
    private String beerStyle;
    private Long upc;



}
