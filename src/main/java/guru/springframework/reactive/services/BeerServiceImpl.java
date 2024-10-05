package guru.springframework.reactive.services;

import guru.springframework.reactive.mappers.BeerMapper;
import guru.springframework.reactive.model.BeerDTO;
import guru.springframework.reactive.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * Service implementation for managing beer-related operations.
 * <p>
 * This class provides the implementation of the BeerService interface,
 * handling the retrieval of beer data in a reactive manner.
 * <p>
 * Created by jt, Spring Framework Guru.
 * <p>
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

    /**
     * Retrieves a beer by its ID.
     * <p>
     * This method retrieves a Mono containing a BeerDTO object representing the beer with the given ID.
     *
     * @param beerId the ID of the beer to retrieve
     * @return a Mono containing a BeerDTO object
     */
    @Override
    public Mono<BeerDTO> getBeerById(Integer beerId) {
        return beerRepository.findById(beerId)
                .map(beerMapper::beerToBeerDTO);
    }

    /**
     * Saves a beer.
     * <p>
     * This method saves the given BeerDTO object and returns a Mono containing the saved BeerDTO object.
     *
     * @param beerDTO the BeerDTO object to save
     * @return a Mono containing the saved BeerDTO object
     */
    @Override
    public Mono<BeerDTO> saveBeer(BeerDTO beerDTO) {
        return beerRepository.save(beerMapper.beerDTOToBeer(beerDTO))
                .map(beerMapper::beerToBeerDTO);
    }

    /**
     * Updates a beer.
     * <p>
     * This method updates the beer with the given ID using the provided BeerDTO object and returns a Mono containing the updated BeerDTO object.
     *
     * @param beerId the ID of the beer to update
     * @param beerDTO the BeerDTO object with the updated data
     * @return a Mono containing the updated BeerDTO object
     */
    @Override
    public Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO beerDTO) {
        return beerRepository.findById(beerId).map(foundBeer -> {
            foundBeer.setBeerName(beerDTO.getBeerName());
            foundBeer.setBeerStyle(beerDTO.getBeerStyle());
            foundBeer.setUpc(beerDTO.getUpc());
            foundBeer.setQuantityOnHand(beerDTO.getQuantityOnHand());
            foundBeer.setPrice(beerDTO.getPrice());

            return foundBeer;
        }).flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDTO);
    }

    /**
     * Patches a beer.
     * <p>
     * This method updates the beer with the given ID using the provided BeerDTO object and returns a Mono containing the updated BeerDTO object.
     *
     * @param beerId  the ID of the beer to patch
     * @param beerDTO the BeerDTO object with the updated data
     * @return a Mono containing the updated BeerDTO object
     */
    @Override
    public Mono<BeerDTO> patchBeer(Integer beerId, BeerDTO beerDTO) {
        return beerRepository.findById(beerId).map(foundBeer -> {
            if (StringUtils.hasText(beerDTO.getBeerName())) {
                foundBeer.setBeerName(beerDTO.getBeerName());
            }
            if (StringUtils.hasText(beerDTO.getBeerStyle())) {
                foundBeer.setBeerStyle(beerDTO.getBeerStyle());
            }
            if (StringUtils.hasText(beerDTO.getUpc())) {
                foundBeer.setUpc(beerDTO.getUpc());
            }
            if (beerDTO.getQuantityOnHand() != null) {
                    foundBeer.setQuantityOnHand(beerDTO.getQuantityOnHand());
            }
            if (beerDTO.getPrice() != null) {
                foundBeer.setPrice(beerDTO.getPrice());
            }
            return foundBeer;
        }).flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDTO);
    }

    /**
     * Deletes a beer.
     * <p>
     * This method deletes the beer with the given ID.
     *
     * @param beerId the ID of the beer to delete
     * @return a Mono<Void> indicating the completion of the operation
     */
    @Override
    public Mono<Void> deleteBeer(Integer beerId) {
        return beerRepository.deleteById(beerId);
    }

}
