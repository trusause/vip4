package com.trusause.dubbosimulate.framework;

import com.trusause.dubbosimulate.protocol.http.HttpClient;
import com.trusause.dubbosimulate.protocol.http.Invocation;
import com.trusause.dubbosimulate.provider.URL;
import com.trusause.dubbosimulate.provider.api.HelloService;
import com.trusause.dubbosimulate.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @Author weicl
 * @Date 2022/7/6 下午5:27
 * @Version 1.0
 * @Description
 */
public class ProxyFactory<T> {

    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), args, method.getParameterTypes());
                List<URL> urlList = RemoteMapRegister.get(interfaceClass.getName());
                URL url = LoadBalance.random(urlList);
//                Protocol protocol = ProtocolFactory.getProtocol();
//                String result = protocol.send(url,invocation);
//                return result;
//                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), args, method.getParameterTypes());
                HttpClient httpClient = new HttpClient();
                String result = httpClient.send(url.getHostname(), url.getPort(), invocation);
                System.out.println("消费者执行完之后的结果：" + result);
                return result;
            }

            ;
        });
    }

}
