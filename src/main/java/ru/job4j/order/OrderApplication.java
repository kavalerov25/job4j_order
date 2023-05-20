package ru.job4j.order;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@Slf4j
public class OrderApplication {
    private static final String URL = "http://localhost:8080/orders";


    @Bean
    public SpringLiquibase liquibase(DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/liquibase-changeLog.xml");
        liquibase.setDataSource(ds);
        return liquibase;
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
        log.info("GO TO {}", URL);
    }

}