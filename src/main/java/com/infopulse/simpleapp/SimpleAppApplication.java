package com.infopulse.simpleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.infopulse.simpleapp")
@EnableJpaRepositories(basePackages = "com.infopulse.simpleapp.repository")
@EnableTransactionManagement
public class SimpleAppApplication { public static void main(String[] args) {
    SpringApplication.run(SimpleAppApplication.class, args);
  }
}
