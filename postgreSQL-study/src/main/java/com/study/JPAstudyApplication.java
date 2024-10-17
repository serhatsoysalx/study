package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JPAstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JPAstudyApplication.class, args);
    }
}