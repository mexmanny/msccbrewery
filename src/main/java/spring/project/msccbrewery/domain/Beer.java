package spring.project.msccbrewery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import spring.project.msccbrewery.web.model.BeerStyleEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Data// is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode, @Getter, @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //Lombok creates a builder for all instance fields in that class.
@Entity

public class Beer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length =36, columnDefinition = "varchar", updatable = false, nullable=false)
    private UUID id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    private String beerName;

    private BeerStyleEnum beerStyleEnum;

    @Column(unique = true)
    private Long upc;

    private BigDecimal price;

    private Integer quantityOnHand;

    private String beerStyle;

    private Integer quantityToBrew;



}
