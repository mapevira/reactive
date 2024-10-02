package guru.springframework.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for Beer.
 * <p>
 * This class is used to transfer beer data between processes. It includes
 * properties such as the beer's identification, name, style, UPC code,
 * quantity on hand, price, and timestamps for creation and last modification.
 * <p>
 * Created by jt, Spring Framework Guru.
 * <p>
 * @author architecture - rperezv
 * @version 02/10/2024 - 09:13
 * @since jdk 1.17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerDTO {

    /**
     * The unique identifier for the beer.
     */
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
    private Double price;

    /**
     * The timestamp when the beer was created.
     */
    private LocalDateTime createdDate;

    /**
     * The timestamp when the beer was last modified.
     */
    private LocalDateTime lastModifiedDate;

}
