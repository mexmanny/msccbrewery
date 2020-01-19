package spring.project.msccbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data // is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode, @Getter, @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //Lombok creates a builder for all instance fields in that class.
public class BeerDto {

    private UUID id ;
    private Integer version;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    private String beerName;

    private BeerStyleEnum beerStyleEnum;

    private Long upc;

    private BigDecimal price;

    private Integer quantityOnHand;



}
