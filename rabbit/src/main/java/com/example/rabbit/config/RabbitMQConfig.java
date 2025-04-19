package com.example.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "helloQueue";

    @Bean
    public Queue helloQueue() {
        return new Queue(QUEUE, false); // not durable for this demo
    }
}

