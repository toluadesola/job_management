package com.tolulope.payoneer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableJpaAuditing
public class PayoneerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayoneerApplication.class, args);
    }

}
