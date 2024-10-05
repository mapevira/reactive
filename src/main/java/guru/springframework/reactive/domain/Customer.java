package guru.springframework.reactive.domain;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * Represents a Customer entity in the system.
 * <p>
 * This class is used to model the properties and behavior of a customer object,
 * including its identification, name, and timestamps for creation and last modification.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 05/10/2024 - 09:44
 * @since jdk 1.17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    /**
     * The unique identifier for the customer.
     */
    @Id
    private Integer id;

    /**
     * The name of the customer.
     */
    @Size(max = 255)
    private String customerName;

    /**
     * The timestamp when the customer was created.
     */
    @CreatedDate
    private LocalDateTime createdDate;

    /**
     * The timestamp when the customer was last modified.
     */
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
