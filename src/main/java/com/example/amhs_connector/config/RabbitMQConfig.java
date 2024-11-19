package com.example.amhs_connector.config;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.impl.StreamEnvironmentBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.rabbit.stream.config.StreamRabbitListenerContainerFactory;
import org.springframework.rabbit.stream.producer.RabbitStreamTemplate;

@Configuration
public class RabbitMQConfig {
    @Bean
    Environment env(RabbitProperties rabbitProperties) {
        return new StreamEnvironmentBuilder()
                .host(rabbitProperties.getHost())
                .port(rabbitProperties.getStream().getPort())
                .username(rabbitProperties.getUsername())
                .password(rabbitProperties.getPassword())
                .virtualHost(rabbitProperties.getVirtualHost())
                .build();
    }

    @Bean
    public RabbitStreamTemplate rabbitStreamTemplate(Environment rabbitStreamEnvironment) {
        return new RabbitStreamTemplate(rabbitStreamEnvironment, "amhs_stream");
    }
}