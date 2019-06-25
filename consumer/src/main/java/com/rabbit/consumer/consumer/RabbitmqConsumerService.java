package com.rabbit.consumer.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author purgeyao
 * @since 1.0
 */
@Service
public class RabbitmqConsumerService {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "test-queue", durable = "true"),
                    exchange = @Exchange(value = "test-exchange", type = "topic"),
                    key = "routingkey-test"
            )
    )
    @RabbitHandler
    public void testConsumer(@Payload String msg, Channel channel, @Headers Map<String, Object> headers) {
        System.out.println(msg);
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            // false表示不批量接收，只接收当前消息
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
