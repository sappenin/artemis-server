package org.artemis.server;

import org.artemis.db.ConnectorPersistenceConfig;
import org.artemis.server.config.JacksonConfig;
import org.artemis.server.config.SecurityConfig;
import org.artemis.server.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// A convenience annotation that adds all of the following:
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class) // Excluded for `problems` support
@EnableWebMvc
//@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
@ComponentScan(basePackages = "org.artemis.server.controllers")
@Import({
    SecurityConfig.class,
    WebConfig.class,
    ConnectorPersistenceConfig.class,
    JacksonConfig.class
})
public class ArtemisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisApplication.class, args);
    }

}
// @Configuration, @EnableAutoConfiguration, @EnableWebMvc,and @ComponentScan

