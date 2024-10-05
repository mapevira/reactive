package guru.springframework.reactive.repositories;

import guru.springframework.reactive.domain.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Repository interface for managing Customer entities.
 * <p>
 * This interface extends ReactiveCrudRepository to provide CRUD operations
 * for Customer entities in a reactive manner.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - raulp
 * @version 05/10/2024 - 11:21
 * @since jdk 1.21
 */
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
