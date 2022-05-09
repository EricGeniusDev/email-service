package com.example.emailservice.service.impl;

import com.example.emailservice.service.MensageriaService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitMQService implements MensageriaService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void salvarMensagem(String routingKey, Object message) {
        rabbitTemplate.convertAndSend(routingKey,message);
    }
}
