package guru.springframework.reactive.controllers;

import guru.springframework.reactive.model.CustomerDTO;
import guru.springframework.reactive.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller for managing customer-related operations.
 * <p>
 * This controller provides endpoints for listing, retrieving, creating, updating,
 * patching, and deleting customers in a reactive manner.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @see guru.springframework.reactive.services.CustomerService
 * @see guru.springframework.reactive.model.CustomerDTO
 * @see reactor.core.publisher.Flux
 * @see reactor.core.publisher.Mono
 *
 * @author architecture - rperezv
 * @version 05/10/2024 - 11:43
 * @since jdk 1.17
 */
@RestController
@RequiredArgsConstructor
public class CustomerController {

    /**
     * Base path for customer-related endpoints.
     */
    public static final String CUSTOMER_PATH = "/api/v2/customer";

    /**
     * Path for customer-related endpoints with a customer ID.
     */
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

    /**
     * Service for managing customer-related operations.
     */
    private final CustomerService customerService;

    /**
     * Endpoint to list all customers.
     * <p>
     * This method handles GET requests to the /api/v2/customer endpoint and returns a Flux of CustomerDTO objects.
     *
     * @return a Flux containing CustomerDTO objects
     */
    @GetMapping(CUSTOMER_PATH)
    Flux<CustomerDTO> listCustomers() {
        return customerService.listCustomers();
    }

    /**
     * Endpoint to retrieve a customer by its ID.
     * <p>
     * This method handles GET requests to the /api/v2/customer/{customerId} endpoint and returns a Mono containing a CustomerDTO object.
     *
     * @param customerId the ID of the customer to retrieve
     * @return a Mono containing a CustomerDTO object
     */
    @GetMapping(CUSTOMER_PATH_ID)
    Mono<CustomerDTO> getCustomerById(@PathVariable Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    /**
     * Endpoint to create a new customer.
     * <p>
     * This method handles POST requests to the /api/v2/customer endpoint and returns a Mono containing a ResponseEntity.
     *
     * @param customerDTO the customer data to create
     * @return a Mono containing a ResponseEntity
     */
    @PostMapping(CUSTOMER_PATH)
    Mono<ResponseEntity<Void>> createCustomer(@Validated @RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO)
                .map(saveDto -> ResponseEntity.created(UriComponentsBuilder
                        .fromHttpUrl("http://localhost:8080" + CUSTOMER_PATH
                                + "/" + saveDto.getId())
                        .build().toUri())
                .build());
    }

    /**
     * Endpoint to update a customer.
     * <p>
     * This method handles PUT requests to the /api/v2/customer/{customerId} endpoint and returns a Mono containing a ResponseEntity.
     *
     * @param customerId the ID of the customer to update
     * @param customerDTO the customer data to update
     * @return a Mono containing a ResponseEntity
     */
    @PutMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> updateCustomer(@PathVariable Integer customerId, @Validated @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerId, customerDTO)
                .map(updatedDto -> ResponseEntity.noContent().build());
    }

    /**
     * Endpoint to patch a customer.
     * <p>
     * This method handles PATCH requests to the /api/v2/customer/{customerId} endpoint and returns a Mono containing a ResponseEntity.
     *
     * @param customerId the ID of the customer to patch
     * @param customerDTO the customer data to patch
     * @return a Mono containing a ResponseEntity
     */
    @PatchMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> patchCustomer(@PathVariable Integer customerId, @Validated @RequestBody CustomerDTO customerDTO) {
        return customerService.patchCustomer(customerId, customerDTO)
                .map(updatedDto -> ResponseEntity.noContent().build());
    }

    /**
     * Endpoint to delete a customer.
     * <p>
     * This method handles DELETE requests to the /api/v2/customer/{customerId} endpoint and returns a Mono containing a ResponseEntity.
     *
     * @param customerId the ID of the customer to delete
     * @return a Mono containing a ResponseEntity
     */
    @DeleteMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> deleteCustomer(@PathVariable Integer customerId) {
        return customerService.deleteCustomer(customerId)
                .thenReturn(ResponseEntity.noContent().build());
    }

}
