package guru.springframework.reactive.controllers;

import guru.springframework.reactive.mappers.BeerMapper;
import guru.springframework.reactive.model.BeerDTO;
import guru.springframework.reactive.repositories.BeerRepositoryTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest
@AutoConfigureWebTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BeerControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    BeerMapper beerMapper;

    @Test
    @Order(1)
    void testListBeers() {
        webTestClient.get().uri(BeerController.BEER_PATH)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("application/json")
                .expectBody().jsonPath("$.size()").isEqualTo(3);

    }

    @Test
    @Order(2)
    void testGetById() {
        webTestClient.get().uri(BeerController.BEER_PATH_ID, 1)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("application/json")
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.beerName").isEqualTo("Galaxy Cat")
                .jsonPath("$.beerStyle").isEqualTo("Pale Ale");
    }

    @Test
    void testCreateBeer() {
        webTestClient.post().uri(BeerController.BEER_PATH)
                .header("Content-Type", "application/json")
                .body(Mono.just(BeerRepositoryTest.getTestBeer()), BeerDTO.class)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().valueEquals("Location", "http://localhost:8080" + BeerController.BEER_PATH + "/4");
    }

    @Test
    @Order(3)
    void testUpdateBeer() {
        webTestClient.put().uri(BeerController.BEER_PATH_ID, 1)
                .header("Content-Type", "application/json")
                .body(Mono.just(BeerRepositoryTest.getTestBeer()), BeerDTO.class)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    @Order(99)
    void testDeleteBeer() {
        webTestClient.delete().uri(BeerController.BEER_PATH_ID, 1)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    void testCreateBeerBadRequest() {

        BeerDTO beerDTO = beerMapper.beerToBeerDTO(BeerRepositoryTest.getTestBeer());
        beerDTO.setBeerName(null);

        webTestClient.post().uri(BeerController.BEER_PATH)
                .header("Content-Type", "application/json")
                .body(Mono.just(beerDTO), BeerDTO.class)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    @Order(4)
    void testUpdateBeerBadRequest() {

        BeerDTO beerDTO = beerMapper.beerToBeerDTO(BeerRepositoryTest.getTestBeer());
        beerDTO.setBeerStyle("");

        webTestClient.put().uri(BeerController.BEER_PATH_ID, 1)
                .header("Content-Type", "application/json")
                .body(Mono.just(beerDTO), BeerDTO.class)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testGetByIdNotFound() {
        webTestClient.get().uri(BeerController.BEER_PATH_ID, 99)
                .exchange()
                .expectStatus().isNotFound();
    }

}