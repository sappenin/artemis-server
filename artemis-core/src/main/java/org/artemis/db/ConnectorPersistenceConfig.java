package org.artemis.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The Connector's Spring Data configuration.
 */
@Configuration
@EnableJpaAuditing
@ComponentScan("org.artemis.db")
@EnableJpaRepositories(basePackages = "org.artemis.db.repositories")
@EntityScan("org.artemis.db.entities")
@Import({
          // Placeholders for now (enable if we ever want custom processing that Spring Boot can't easily provide).
          //H2ConnectorPersistenceConfig.class,
          //PostgresqlConnectorPersistenceConfig.class
        })

public class ConnectorPersistenceConfig {
}
