package com.gujunbin.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: GuJunBin
 * @Date: 2020/4/10 10:29
 * @Description:
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String paymentzk(){
        return "Spring cloud with zookeeper port: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
