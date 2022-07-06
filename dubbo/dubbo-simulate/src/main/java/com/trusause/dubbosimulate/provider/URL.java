package com.trusause.dubbosimulate.provider;

import java.io.Serializable;

/**
 * @Author weicl
 * @Date 2022/7/6 下午3:36
 * @Version 1.0
 * @Description
 */
public class URL implements Serializable {

    private String hostname;
    private Integer port;

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
