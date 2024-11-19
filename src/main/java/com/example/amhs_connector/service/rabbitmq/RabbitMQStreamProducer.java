package com.example.amhs_connector.service.rabbitmq;

import org.springframework.rabbit.stream.producer.RabbitStreamTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQStreamProducer {
    private final RabbitStreamTemplate rabbitStreamTemplate;

    public RabbitMQStreamProducer(RabbitStreamTemplate rabbitStreamTemplate) {
        this.rabbitStreamTemplate = rabbitStreamTemplate;
    }

    public void sendMessage(String message) {
        rabbitStreamTemplate.convertAndSend(message);
        System.out.println("Message sent to RabbitMQ stream: " + message);
    }
}
