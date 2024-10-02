package guru.springframework.reactive.mappers;

import guru.springframework.reactive.domain.Beer;
import guru.springframework.reactive.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Beer and BeerDTO objects.
 * <p>
 * This interface uses MapStruct to generate the implementation code for mapping
 * between Beer entities and BeerDTO data transfer objects.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @see guru.springframework.reactive.domain.Beer
 * @see guru.springframework.reactive.model.BeerDTO
 *
 * @author architecture - raulp
 * @version 02/10/2024 - 14:40
 * @since jdk 1.21
 */
@Mapper
public interface BeerMapper {

    /**
     * Converts a Beer entity to a BeerDTO.
     *
     * @param beer the Beer entity to convert
     * @return the converted BeerDTO
     */
    BeerDTO beerToBeerDTO(Beer beer);

    /**
     * Converts a BeerDTO to a Beer entity.
     *
     * @param beerDTO the BeerDTO to convert
     * @return the converted Beer entity
     */
    Beer beerDTOToBeer(BeerDTO beerDTO);

}
