package com.trusause.dubbosimulate.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.trusause.dubbosimulate.provider.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author weicl
 * @Date 2022/7/6 下午3:59
 * @Version 1.0
 * @Description
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);
            //接口
            String interfaceName = invocation.getInterfaceName();
            //根据接口获取实现类
            Class implClass = LocalRegister.get(interfaceName);
            //实现类的方法
            Method method = null;
            method = implClass.getMethod(invocation.getMethodName(), invocation.getParamType());
            //用反射执行该方法
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());
            System.out.println("tomcat:" + result);
            IOUtils.write(result, resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
