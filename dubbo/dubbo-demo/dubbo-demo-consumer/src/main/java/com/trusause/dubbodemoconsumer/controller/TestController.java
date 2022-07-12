package com.trusause.dubbodemoconsumer.controller;

import com.trusause.dubbodemointerface.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author weicl
 * @Date 2022/7/11 下午5:08
 * @Version 1.0
 * @Description
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Reference(version = "1.4", check = false, parameters = {"protocol", "dubbo"})
    private DemoService demoService;


    @GetMapping("/test1")
    @ResponseBody
    public String test1() {
        demoService.sayHello("test1");
        return "test1";
    }

    @GetMapping("/test2")
    @ResponseBody
    public String test2() {
        return "test2";
    }


}
