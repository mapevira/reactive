package guru.springframework.reactive.services;

import guru.springframework.reactive.model.BeerDTO;
import reactor.core.publisher.Flux;

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

}
