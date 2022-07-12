package com.trusause.dubbodemointerface;

import java.util.concurrent.CompletableFuture;

/**
 * @Author weicl
 * @Date 2022/7/7 下午2:28
 * @Version 1.0
 * @Description
 */
public interface DemoService {

    //同步调用方法
    String sayHello(String name);

    //异步调用方法
    default CompletableFuture<String> sayHelloAsync(String name) {
        return null;
    }

//    default void addListener(String key, DemoServiceListener listener) {
//    }

    //添加回调


}
