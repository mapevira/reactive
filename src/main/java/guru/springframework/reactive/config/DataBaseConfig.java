package guru.springframework.reactive.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

/**
 * Configuration class for setting up the database connection and initialization.
 * <p>
 * This class is responsible for configuring the database connection factory and
 * initializing the database schema using an SQL script.
 * <p>
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 01/10/2024 - 15:36
 * @since jdk 1.17
 */
@Configuration
public class DataBaseConfig {

    /**
     * The resource property is used to load the schema.sql file from the classpath.
     */
    @Value("classpath:schema.sql")
    Resource resource;

    /**
     * Bean definition for initializing the database connection factory.
     * <p>
     * This method creates and configures a ConnectionFactoryInitializer bean, which
     * is responsible for initializing the database schema using the provided SQL script.
     *
     * @param connectionFactory the connection factory to be used for database connections
     * @return the configured ConnectionFactoryInitializer bean
     */
    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(resource));

        return initializer;
    }

}
