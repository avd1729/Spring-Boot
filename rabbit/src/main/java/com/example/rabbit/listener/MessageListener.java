package com.example.rabbit.listener;

import com.example.rabbit.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receive(String message) {
        System.out.println("Received: " + message);
    }
}

