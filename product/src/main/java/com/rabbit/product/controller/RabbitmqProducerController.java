package com.rabbit.product.controller;

import com.rabbit.product.producer.RabbitmqProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author purgeyao
 * @since 1.0
 */
@RestController
public class RabbitmqProducerController {

    @Resource
    private RabbitmqProducerService rabbitmqProducerService;

    @GetMapping("/rabbitmq/{msg}")
    public String test(@PathVariable(name = "msg") String msg) {
        // 调用生产者，发布消息
        rabbitmqProducerService.sendMsg(msg);
        return "SUCCESS";
    }

}
