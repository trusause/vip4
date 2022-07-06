package com.trusause.dubbosimulate.framework;

import com.trusause.dubbosimulate.provider.URL;

import java.util.List;
import java.util.Random;

/**
 * @Author weicl
 * @Date 2022/7/6 下午5:45
 * @Version 1.0
 * @Description 负载均衡
 */
public class LoadBalance {

    public static URL random(List<URL> urlList) {
        Random random = new Random();
        int n = random.nextInt(urlList.size());
        return urlList.get(n);
    }

}
