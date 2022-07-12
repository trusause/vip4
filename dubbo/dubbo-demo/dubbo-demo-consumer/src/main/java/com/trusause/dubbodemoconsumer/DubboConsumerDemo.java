package com.trusause.dubbodemoconsumer;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author weicl
 * @Date 2022/7/7 下午3:58
 * @Version 1.0
 * @Description
 */
//@EnableAutoConfiguration
@EnableDubbo
@SpringBootApplication
public class DubboConsumerDemo {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DubboConsumerDemo.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(DubboConsumerDemo.class);
//        DemoService demoService = context.getBean(DemoService.class);
//        System.out.println(demoService.sayHello("超级赛亚人"));
    }

}
