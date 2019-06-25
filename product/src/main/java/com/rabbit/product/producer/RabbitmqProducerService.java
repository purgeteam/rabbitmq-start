package com.rabbit.product.producer;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author purgeyao
 * @since 1.0
 */
@Service
public class RabbitmqProducerService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, isAck, cause) -> {
        System.out.println(correlationData);
        System.out.println("ack: " + isAck);
        if (!isAck) {
            System.err.println(cause);
        }
    };

    RabbitTemplate.ReturnCallback returnCallback = (message, replyCode, replyText, exchange, routingKey) -> {
        System.out.println("code: " + replyCode + ", text: " + replyText);
        System.out.println("exchange: " + exchange + ", routingKey: " + routingKey);
        System.out.println(message);
    };

    public void sendMsg(String msg) {
        CorrelationData cd = new CorrelationData("id" + System.currentTimeMillis());
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend("test-exchange", "routingkey-test", msg, cd);
    }
}
