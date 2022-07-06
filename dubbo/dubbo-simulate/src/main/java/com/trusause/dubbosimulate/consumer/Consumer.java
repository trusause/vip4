package com.trusause.dubbosimulate.consumer;

import com.trusause.dubbosimulate.framework.ProxyFactory;
import com.trusause.dubbosimulate.provider.api.HelloService;

/**
 * @Author weicl
 * @Date 2022/7/6 下午4:27
 * @Version 1.0
 * @Description
 */
public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("超级赛亚人");
        System.out.println("消费者通过动态代理执行完之后的结果：" + result);

//        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Object[]{"超级赛亚人"}, new Class[]{String.class});
//        HttpClient httpClient = new HttpClient();
//        String result = httpClient.send("localhost", 8080, invocation);
//        System.out.println("消费者执行完之后的结果：" + result);
    }

}
