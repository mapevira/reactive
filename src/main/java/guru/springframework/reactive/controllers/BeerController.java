package guru.springframework.reactive.controllers;

import guru.springframework.reactive.model.BeerDTO;
import guru.springframework.reactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller for handling beer-related requests.
 * <p>
 * This controller provides endpoints for retrieving beer data.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 02/10/2024 - 09:11
 * @since jdk 1.17
 */
@RestController
@RequiredArgsConstructor
public class BeerController {

    /**
     * The base path for beer-related API endpoints.
     */
    public static final String BEER_PATH = "/api/v2/beer";

    /**
     * The path for a specific beer by ID.
     */
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    /**
     * Service for managing beer-related operations.
     */
    private final BeerService beerService;

    /**
     * Endpoint to list all beers.
     * <p>
     * This method handles GET requests to the /api/v2/beer endpoint and returns a Flux of BeerDTO objects.
     *
     * @return a Flux containing BeerDTO objects
     */
    @GetMapping(BeerController.BEER_PATH)
    Flux<BeerDTO> listBeers() {
        return beerService.listBeers();
    }

    /**
     * Endpoint to retrieve a beer by its ID.
     * <p>
     * This method handles GET requests to the /api/v2/beer/{beerId} endpoint and returns a Mono containing a BeerDTO object.
     *
     * @param beerId the ID of the beer to retrieve
     * @return a Mono containing a BeerDTO object
     */
    @GetMapping(BeerController.BEER_PATH_ID)
    Mono<BeerDTO> getBeerById(@PathVariable Integer beerId) {
        return beerService.getBeerById(beerId);
    }

}
