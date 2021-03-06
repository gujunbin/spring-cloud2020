package com.gujunbin.springcloud.comtroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: GuJunBin
 * @Date: 2020/4/17 12:15
 * @Description:
 */
@RestController
@RefreshScope //实现自动刷新
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")    //请求地址
    public String getConfigInfo() {
        return "serverPort:" + serverPort + "\t\n configInfo:" + configInfo;
    }
}
