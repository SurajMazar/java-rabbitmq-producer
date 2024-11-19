package com.example.amhs_connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AMHSConnectorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AMHSConnectorApplication.class, args);
    }
}
