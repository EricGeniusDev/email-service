package com.example.emailservice.consumer;

import com.example.emailservice.dto.EmailDTO;
import com.example.emailservice.constants.RabbitMqConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailConsumer {

    @RabbitListener(queues = RabbitMqConstants.EMAIL)
    private void consomeEmail(EmailDTO emailDTO){
        log.info("TO: {}",emailDTO.to);
    }
}
