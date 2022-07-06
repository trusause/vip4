package com.trusause.dubbosimulate.protocol.http;


import com.alibaba.fastjson.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @Author weicl
 * @Date 2022/7/6 下午4:32
 * @Version 1.0
 * @Description
 */
public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) {
        try {
            //JDK 11的新特性
            var request = HttpRequest.newBuilder()
                    .uri(new URI("http", null, hostname, port, "/", null, null))
                    .POST(HttpRequest.BodyPublishers.ofString(JSONObject.toJSONString(invocation)))
                    .build();
            var client = java.net.http.HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String result = response.body();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
