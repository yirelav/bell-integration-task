package ru.yirelav.bellintegrationtask;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;

@SpringBootApplication
@EnableJpaRepositories
public class BellIntegrationTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BellIntegrationTaskApplication.class, args);
    }

}
