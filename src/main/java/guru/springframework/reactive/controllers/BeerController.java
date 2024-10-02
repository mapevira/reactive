package guru.springframework.reactive.controllers;

import guru.springframework.reactive.model.BeerDTO;
import guru.springframework.reactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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

    /**
     * Endpoint to save a beer.
     * <p>
     * This method handles POST requests to the /api/v2/beer endpoint and returns a Mono containing the saved BeerDTO object.
     *
     * @param beerDTO the BeerDTO object to save
     * @return a Mono containing the saved BeerDTO object
     */
    @PostMapping(BeerController.BEER_PATH)
    Mono<ResponseEntity<Void>> saveBeer(@RequestBody BeerDTO beerDTO) {
        return beerService.saveBeer(beerDTO)
                .map(saveBeerDTO -> ResponseEntity.created(UriComponentsBuilder
                                .fromHttpUrl("http://localhost:8080" + BEER_PATH
                                + "/" + saveBeerDTO.getId())
                                .build().toUri())
                        .build());
    }

}
