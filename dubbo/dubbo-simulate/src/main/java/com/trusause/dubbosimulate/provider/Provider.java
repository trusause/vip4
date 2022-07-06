package com.trusause.dubbosimulate.provider;

import com.trusause.dubbosimulate.protocol.http.HttpServer;
import com.trusause.dubbosimulate.provider.api.HelloService;
import com.trusause.dubbosimulate.provider.impl.HelloServiceImpl;
import com.trusause.dubbosimulate.register.RemoteMapRegister;

import java.net.MalformedURLException;

/**
 * @Author weicl
 * @Date 2022/7/6 下午3:19
 * @Version 1.0
 * @Description
 */
public class Provider {

    private static boolean isRun = true;

    public static void main(String[] args) throws MalformedURLException {
        //1、注册服务
        //2、本地注册
        //3、启动tomcat

        //注册服务
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.regist(HelloService.class.getName(), url);

        //服务：实现类
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);

    }

}
