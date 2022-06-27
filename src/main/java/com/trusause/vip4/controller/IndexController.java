package com.trusause.vip4.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author weicl
 * @Date 2022/6/21 下午5:49
 * @Version 1.0
 * @Description
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    Redisson redisson;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello2";
    }

    @ResponseBody
    @GetMapping("/deduct_stock")
    public String deductStock() {
        String lockKey = "product_001";
        String clientId = UUID.randomUUID().toString();
        //新增加的
        RLock redissonLock = redisson.getLock(lockKey);
        try {
            //新增加的：加锁，实现锁续命
            redissonLock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stockNumber"));
            if (stock > 0) {
                //扣减库存并存储到redis中
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stockNumber", realStock + "");
                System.out.println("扣减成功，剩余库存：" + realStock);
            } else {
                System.out.println("扣减库存失败");
            }
        } finally {
            //新增加的
            redissonLock.unlock();
        }
        return "hello";
    }

}
