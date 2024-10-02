package guru.springframework.reactive.services;

import guru.springframework.reactive.mappers.BeerMapper;
import guru.springframework.reactive.model.BeerDTO;
import guru.springframework.reactive.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Service implementation for managing beer-related operations.
 * <p>
 * This class provides the implementation of the BeerService interface,
 * handling the retrieval of beer data in a reactive manner.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 02/10/2024 - 14:48
 * @since jdk 1.17
 */
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    /**
     * Repository for accessing beer data.
     */
    private final BeerRepository beerRepository;

    /**
     * Mapper for converting between Beer and BeerDTO objects.
     */
    private final BeerMapper beerMapper;

    /**
     * Lists all beers.
     * <p>
     * This method retrieves a Flux stream of BeerDTO objects representing all beers.
     *
     * @return a Flux containing BeerDTO objects
     */
    @Override
    public Flux<BeerDTO> listBeers() {
        return beerRepository.findAll().map(beerMapper::beerToBeerDTO);
    }

}
