package guru.springframework.reactive.services;

import guru.springframework.reactive.mappers.CustomerMapper;
import guru.springframework.reactive.model.CustomerDTO;
import guru.springframework.reactive.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service implementation for managing customer-related operations.
 * <p>
 * This class provides the implementation of the CustomerService interface,
 * handling the retrieval, saving, updating, patching, and deleting of customer data
 * in a reactive manner.
 * <p>
 * Created by jt, Spring Framework Guru.
 * <p>
 * @see guru.springframework.reactive.services.CustomerService
 * @see guru.springframework.reactive.model.CustomerDTO
 * @see reactor.core.publisher.Flux
 * @see reactor.core.publisher.Mono
 * @author architecture - rperezv
 * @version 05/10/2024 - 11:32
 * @since jdk 1.17
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    /**
     * Repository for accessing customer data.
     */
    private final CustomerRepository customerRepository;

    /**
     * Mapper for converting between Customer and CustomerDTO objects.
     */
    private final CustomerMapper customerMapper;

    /**
     * Lists all customers.
     * <p>
     * This method retrieves a Flux stream of CustomerDTO objects representing all customers.
     *
     * @return a Flux containing CustomerDTO objects
     */
    @Override
    public Flux<CustomerDTO> listCustomers() {
        return customerRepository.findAll()
                .map(customerMapper::customerToCustomerDTO);
    }

    /**
     * Retrieves a customer by its ID.
     * <p>
     * This method retrieves a Mono containing a CustomerDTO object representing the customer with the specified ID.
     *
     * @param customerId the ID of the customer to retrieve
     * @return a Mono containing the CustomerDTO object
     */
    @Override
    public Mono<CustomerDTO> getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::customerToCustomerDTO);
    }

    /**
     * Saves a new customer.
     * <p>
     * This method saves a new customer using the provided CustomerDTO object.
     *
     * @param customerDTO the CustomerDTO object representing the new customer
     * @return a Mono containing the saved CustomerDTO object
     */
    @Override
    public Mono<CustomerDTO> saveCustomer(CustomerDTO customerDTO) {
        return customerRepository.save(customerMapper.customerDTOToCustomer(customerDTO))
                .map(customerMapper::customerToCustomerDTO);
    }

    /**
     * Updates an existing customer.
     * <p>
     * This method updates an existing customer with the specified ID using the provided CustomerDTO object.
     *
     * @param customerId  the ID of the customer to update
     * @param customerDTO the CustomerDTO object representing the updated customer
     * @return a Mono containing the updated CustomerDTO object
     */
    @Override
    public Mono<CustomerDTO> updateCustomer(Integer customerId, CustomerDTO customerDTO) {
        return customerRepository.findById(customerId).map(customer -> {
            customer.setCustomerName(customerDTO.getCustomerName());

            return customer;
        }).flatMap(customerRepository::save)
                .map(customerMapper::customerToCustomerDTO);
    }

    /**
     * Patches an existing customer.
     * <p>
     * This method updates an existing customer with the specified ID using the provided CustomerDTO object.
     *
     * @param customerId  the ID of the customer to update
     * @param customerDTO the CustomerDTO object representing the updated customer
     * @return a Mono containing the updated CustomerDTO object
     */
    @Override
    public Mono<CustomerDTO> patchCustomer(Integer customerId, CustomerDTO customerDTO) {
        return customerRepository.findById(customerId).map(customer -> {
            if (StringUtils.hasText(customerDTO.getCustomerName())) {
                customer.setCustomerName(customerDTO.getCustomerName());
            }

            return customer;
        }).flatMap(customerRepository::save)
                .map(customerMapper::customerToCustomerDTO);
    }

    /**
     * Deletes a customer.
     * <p>
     * This method deletes the customer with the specified ID.
     *
     * @param customerId the ID of the customer to delete
     * @return a Mono indicating when the operation has completed
     */
    @Override
    public Mono<Void> deleteCustomer(Integer customerId) {
        return customerRepository.findById(customerId)
                .flatMap(customerRepository::delete);
    }

}
