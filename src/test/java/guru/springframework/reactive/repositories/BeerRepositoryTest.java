package guru.springframework.reactive.repositories;

import guru.springframework.reactive.domain.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DataR2dbcTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void saveBeer() {
        Beer beer = getTestBeer();

        beerRepository.save(beer).subscribe(System.out::println);

        var savedBeerMono = beerRepository.findById(beer.getId());

        savedBeerMono.subscribe(savedBeer -> {
            assertEquals(beer.getId(), savedBeer.getId());
            assertEquals(beer.getBeerName(), savedBeer.getBeerName());
            assertEquals(beer.getBeerStyle(), savedBeer.getBeerStyle());
            assertEquals(beer.getUpc(), savedBeer.getUpc());
            assertEquals(beer.getQuantityOnHand(), savedBeer.getQuantityOnHand());
            assertEquals(beer.getPrice(), savedBeer.getPrice());
        });

    }

    Beer getTestBeer() {
        return Beer.builder()
                .beerName("Test Beer")
                .beerStyle("IPA")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(12)
                .upc("123456789012")
                .build();
    }
}