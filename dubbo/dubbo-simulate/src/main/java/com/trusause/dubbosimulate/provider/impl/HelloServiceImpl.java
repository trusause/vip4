package com.trusause.dubbosimulate.provider.impl;

import com.trusause.dubbosimulate.provider.api.HelloService;

/**
 * @Author weicl
 * @Date 2022/7/6 下午3:17
 * @Version 1.0
 * @Description
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String username) {
        return "hello" + username;
    }

}
