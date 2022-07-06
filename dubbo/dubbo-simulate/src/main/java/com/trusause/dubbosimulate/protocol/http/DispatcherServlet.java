package com.trusause.dubbosimulate.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author weicl
 * @Date 2022/7/6 下午3:56
 * @Version 1.0
 * @Description
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        new HttpServerHandler().handler(req, resp);
    }

}
