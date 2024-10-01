package guru.springframework.reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a Beer entity in the system.
 * <p>
 * This class is used to model the properties and behavior of a beer object,
 * including its identification, name, style, UPC code, quantity on hand,
 * price, and timestamps for creation and last modification.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 01/10/2024 - 15:49
 * @since jdk 1.17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Beer {

    /**
     * The unique identifier for the beer.
     */
    @Id
    private Integer id;

    /**
     * The name of the beer.
     */
    private String beerName;

    /**
     * The style of the beer (e.g., IPA, Stout).
     */
    private String beerStyle;

    /**
     * The Universal Product Code (UPC) for the beer.
     */
    private String upc;

    /**
     * The quantity of beer available on hand.
     */
    private Integer quantityOnHand;

    /**
     * The price of the beer.
     */
    private BigDecimal price;

    /**
     * The timestamp when the beer was created.
     */
    @CreatedDate
    private LocalDateTime createdDate;

    /**
     * The timestamp when the beer was last modified.
     */
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
