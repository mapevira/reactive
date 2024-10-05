package guru.springframework.reactive.services;

import guru.springframework.reactive.model.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service interface for managing customer-related operations.
 * <p>
 * This interface defines methods for retrieving, saving, updating, patching,
 * and deleting customer data in a reactive manner.
 * <p>
 * Created by jt, Spring Framework Guru.
 * @author architecture - rperezv
 * @version 05/10/2024 - 11:26
 * @since jdk 1.17
 */
public interface CustomerService {

    /**
     * Lists all customers.
     * <p>
     * This method retrieves a Flux stream of CustomerDTO objects representing all customers.
     *
     * @return a Flux containing CustomerDTO objects
     */
    Flux<CustomerDTO> listCustomers();

    /**
     * Retrieves a customer by its ID.
     * <p>
     * This method retrieves a Mono containing a CustomerDTO object representing the customer with the specified ID.
     *
     * @param customerId the ID of the customer to retrieve
     * @return a Mono containing the CustomerDTO object
     */
    Mono<CustomerDTO> getCustomerById(Integer customerId);

    /**
     * Saves a new customer.
     * <p>
     * This method saves a new customer using the provided CustomerDTO object.
     *
     * @param customerDTO the CustomerDTO object representing the new customer
     * @return a Mono containing the saved CustomerDTO object
     */
    Mono<CustomerDTO> saveCustomer(CustomerDTO customerDTO);

    /**
     * Updates an existing customer.
     * <p>
     * This method updates an existing customer with the specified ID using the provided CustomerDTO object.
     *
     * @param customerId the ID of the customer to update
     * @param customerDTO the CustomerDTO object representing the updated customer
     * @return a Mono containing the updated CustomerDTO object
     */
    Mono<CustomerDTO> updateCustomer(Integer customerId, CustomerDTO customerDTO);

    /**
     * Patches an existing customer.
     * <p>
     * This method updates an existing customer with the specified ID using the provided CustomerDTO object.
     *
     * @param customerId the ID of the customer to update
     * @param customerDTO the CustomerDTO object representing the updated customer
     * @return a Mono containing the updated CustomerDTO object
     */
    Mono<CustomerDTO> patchCustomer(Integer customerId, CustomerDTO customerDTO);

    /**
     * Deletes a customer.
     * <p>
     * This method deletes the customer with the specified ID.
     *
     * @param customerId the ID of the customer to delete
     * @return a Mono indicating when the operation has completed
     */
    Mono<Void> deleteCustomer(Integer customerId);

}
