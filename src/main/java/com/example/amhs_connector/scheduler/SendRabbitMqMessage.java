package com.example.amhs_connector.scheduler;

import com.example.amhs_connector.service.rabbitmq.RabbitMQStreamProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SendRabbitMqMessage  {
    private final RabbitMQStreamProducer rabbitMQStreamProducer;

    public SendRabbitMqMessage(RabbitMQStreamProducer rabbitMQStreamProducer) {
        this.rabbitMQStreamProducer = rabbitMQStreamProducer;
    }

    @Scheduled(fixedRate = 5000)
    public void periodicTask() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        rabbitMQStreamProducer.sendMessage("This is new message from spring boot " + currentDateTime);
    }
}
