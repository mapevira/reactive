package guru.springframework.reactive.services;

import guru.springframework.reactive.model.BeerDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * Service interface for managing beer-related operations.
 * <p>
 * This interface defines methods for retrieving beer data in a reactive manner.
 *
 * @author architecture - raulp
 * @version 02/10/2024 - 14:46
 * @since jdk 1.21
 */
public interface BeerService {

    /**
     * Lists all beers.
     * <p>
     * This method retrieves a Flux stream of BeerDTO objects representing all beers.
     *
     * @return a Flux containing BeerDTO objects
     */
    Flux<BeerDTO> listBeers();

    /**
     * Retrieves a beer by its ID.
     * <p>
     * This method retrieves a Mono containing a BeerDTO object representing the beer with the given ID.
     *
     * @param beerId the ID of the beer to retrieve
     * @return a Mono containing a BeerDTO object
     */
    Mono<BeerDTO> getBeerById(Integer beerId);

    /**
     * Saves a beer.
     * <p>
     * This method saves the given BeerDTO object and returns a Mono containing the saved BeerDTO object.
     *
     * @param beerDTO the BeerDTO object to save
     * @return a Mono containing the saved BeerDTO object
     */
    Mono<BeerDTO> saveBeer(BeerDTO beerDTO);

    /**
     * Updates a beer.
     * <p>
     * This method updates the beer with the given ID using the provided BeerDTO object and returns a Mono containing the updated BeerDTO object.
     *
     * @param beerId the ID of the beer to update
     * @param beerDTO the BeerDTO object with the updated data
     * @return a Mono containing the updated BeerDTO object
     */
    Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO beerDTO);

    /**
     * Patches a beer.
     * <p>
     * This method updates the beer with the given ID using the provided BeerDTO object and returns a Mono containing the updated BeerDTO object.
     *
     * @param beerId the ID of the beer to patch
     * @param beerDTO the BeerDTO object with the updated data
     * @return a Mono containing the updated BeerDTO object
     */
    Mono<BeerDTO> patchBeer(Integer beerId, BeerDTO beerDTO);

    /**
     * Deletes a beer.
     * <p>
     * This method deletes the beer with the given ID.
     *
     * @param beerId the ID of the beer to delete
     * @return a Mono<Void> indicating the completion of the operation
     */
    Mono<Void> deleteBeer(Integer beerId);

}
