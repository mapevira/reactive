package guru.springframework.reactive.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for Customer.
 * <p>
 * This class is used to transfer customer data between processes. It includes
 * properties such as the customer's identification, name, and timestamps for
 * creation and last modification.
 * <p>
 * Created by jt, Spring Framework Guru.
 * <p>
 * @author architecture - rperezv
 * @version 05/10/2024 - 11:14
 * @since jdk 1.17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    /**
     * The unique identifier for the customer.
     */
    private Integer id;

    /**
     * The name of the customer.
     */
    @NotNull
    @Size(min=3, max = 255)
    private String customerName;

    /**
     * The timestamp when the customer was created.
     */
    private LocalDateTime createdDate;

    /**
     * The timestamp when the customer was last modified.
     */
    private LocalDateTime lastModifiedDate;

}
