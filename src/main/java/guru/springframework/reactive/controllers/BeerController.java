package guru.springframework.reactive.controllers;

import guru.springframework.reactive.model.BeerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
public class BeerController {

    /**
     * The base path for beer-related API endpoints.
     */
    public static final String BEER_PATH = "/api/v2/beer";

    /**
     * Endpoint to list all beers.
     * <p>
     * This method handles GET requests to the /api/v2/beer endpoint and returns a Flux of BeerDTO objects.
     *
     * @return a Flux containing BeerDTO objects
     */
    @GetMapping(BeerController.BEER_PATH)
    Flux<BeerDTO> listBeers() {
        return Flux.just(BeerDTO.builder().id(1).build(),
                BeerDTO.builder().id(2).build());
    }

}
