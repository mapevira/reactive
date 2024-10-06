package guru.springframework.reactive.repositories;

import guru.springframework.reactive.config.DataBaseConfig;
import guru.springframework.reactive.domain.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataR2dbcTest
@Import(DataBaseConfig.class)
public class BeerRepositoryTest {

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

    public static Beer getTestBeer() {
        return Beer.builder()
                .beerName("Test Beer")
                .beerStyle("IPA")
                .price(9.99)
                .quantityOnHand(12)
                .upc("123456789012")
                .build();
    }
}