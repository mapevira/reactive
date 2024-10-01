package guru.springframework.reactive.repositories;

import guru.springframework.reactive.domain.Beer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Repository interface for Beer entities.
 * <p>
 * This interface extends ReactiveCrudRepository to provide CRUD operations
 * for Beer entities in a reactive manner.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @see org.springframework.data.repository.reactive.ReactiveCrudRepository
 * @see guru.springframework.reactive.domain.Beer

 * @version 01/10/2024 - 15:58
 * @since jdk 1.21
 */
public interface BeerRepository extends ReactiveCrudRepository<Beer, Integer> {
}
