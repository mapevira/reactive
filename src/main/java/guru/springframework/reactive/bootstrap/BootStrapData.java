package guru.springframework.reactive.bootstrap;

import guru.springframework.reactive.domain.Beer;
import guru.springframework.reactive.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Bootstrap data loader for initializing the database with sample beer data.
 * <p>
 * This component implements CommandLineRunner to execute code after the Spring Boot application
 * has started. It checks if the Beer repository is empty and, if so, populates it with sample data.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 01/10/2024 - 16:41
 * @since jdk 1.17
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class BootStrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;

    /**
     * Initializes the database with sample beer data.
     * <p>
     * This method checks if the Beer repository is empty and, if so, populates it with sample data.
     *
     * @param args the command-line arguments
     * @throws Exception if an error occurs
     */
    @Override
    public void run(String... args) throws Exception {
        loadBeerData();

        beerRepository.count().subscribe(count -> log.info("Count is: {}", count));
    }

    /**
     * Populates the Beer repository with sample data.
     * <p>
     * This method checks if the Beer repository is empty and, if so, populates it with sample data.
     */
    private void loadBeerData() {
        beerRepository.count().subscribe(count -> {
            if (count == 0) {
                Beer beer1 = Beer.builder()
                        .beerName("Galaxy Cat")
                        .beerStyle("Pale Ale")
                        .upc("12356")
                        .price(Double.valueOf("12.99"))
                        .quantityOnHand(122)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Beer beer2 = Beer.builder()
                        .beerName("Crank")
                        .beerStyle("Pale Ale")
                        .upc("12356222")
                        .price(Double.valueOf("11.99"))
                        .quantityOnHand(392)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Beer beer3 = Beer.builder()
                        .beerName("Sunshine City")
                        .beerStyle("IPA")
                        .upc("12356")
                        .price(Double.valueOf("13.99"))
                        .quantityOnHand(144)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                beerRepository.save(beer1).subscribe();
                beerRepository.save(beer2).subscribe();
                beerRepository.save(beer3).subscribe();
            }
        });
    }
}
