package ru.yirelav.bellintegrationtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BellIntegrationTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BellIntegrationTaskApplication.class, args);
    }

}
