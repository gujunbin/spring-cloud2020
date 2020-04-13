package com.gujunbin.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: GuJunBin
 * @Date: 2020/4/13 14:31
 * @Description:
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return java.lang.String
     * @author GuJunBin
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() +
               "  paymentInfo_OK,id:  " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     *
     * @param id
     * @return java.lang.String
     * @author GuJunBin
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties ={
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {

        /**
         * 模拟线程异常 也会跳转至 paymentInfo_TimeOutHandler兜底方法
         * int age= 1/0;
         */

        Integer Time = 1;
        //模拟线程耗时
        try {
            TimeUnit.SECONDS.sleep(Time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() +
               " id: " + id + "\t" + "(*^▽^*)  耗时（s）：" + Time;
    }


    public String paymentInfo_TimeOutHandler(Integer id) {
        return "程序运行繁忙或报错,请稍后再试*****" + "当前线程: " +
                Thread.currentThread().getName() + id + "\t " + "(꒦_꒦) )";
    }
}
