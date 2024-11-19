package com.example.amhs_connector;

import com.example.amhs_connector.service.rabbitmq.RabbitMQStreamProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmhsConnectorApplication implements CommandLineRunner {

    private final RabbitMQStreamProducer rabbitMQStreamProducer;

    public AmhsConnectorApplication(RabbitMQStreamProducer rabbitMQStreamProducer) {
        this.rabbitMQStreamProducer = rabbitMQStreamProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(AmhsConnectorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        rabbitMQStreamProducer.sendMessage("This is new message from spring boot part 2");
    }
}
