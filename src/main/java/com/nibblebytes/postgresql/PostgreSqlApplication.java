package com.nibblebytes.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class PostgreSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgreSqlApplication.class, args);
    }

}
