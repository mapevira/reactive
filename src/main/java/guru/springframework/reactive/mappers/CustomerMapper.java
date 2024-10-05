package guru.springframework.reactive.mappers;

import guru.springframework.reactive.domain.Customer;
import guru.springframework.reactive.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Customer and CustomerDTO objects.
 * <p>
 * This interface uses MapStruct to generate the implementation code for mapping
 * between Customer entities and CustomerDTO data transfer objects.
 * <p>
 * Created by jt, Spring Framework Guru.
 * @author architecture - raulp
 * @version 05/10/2024 - 11:19
 * @since jdk 1.21
 */
@Mapper
public interface CustomerMapper {

    /**
     * Converts a CustomerDTO to a Customer entity.
     *
     * @param customerDTO the CustomerDTO to convert
     * @return the converted Customer entity
     */
    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    /**
     * Converts a Customer entity to a CustomerDTO.
     *
     * @param customer the Customer entity to convert
     * @return the converted CustomerDTO
     */
    CustomerDTO customerToCustomerDTO(Customer customer);

}
