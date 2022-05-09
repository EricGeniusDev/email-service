package com.example.emailservice.connection;

import com.example.emailservice.constants.RabbitMqConstants;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private static final String EXCHANGE_NAME = "amq.direct";
    private final AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue createQueue(String queueName){
        return new Queue(queueName,true,false,false);
    }

    private DirectExchange createDirectExchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    private Binding createBinding(Queue queue, DirectExchange directExchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE,directExchange.getName(),queue.getName(),null);
    }

    @PostConstruct
    private void adiciona(){
        var emailQueue = createQueue(RabbitMqConstants.EMAIL);
        var directiveExchange = createDirectExchange();
        var bind = createBinding(emailQueue,directiveExchange);

        this.amqpAdmin.declareQueue(emailQueue);
        this.amqpAdmin.declareExchange(directiveExchange);
        this.amqpAdmin.declareBinding(bind);
    }

}
