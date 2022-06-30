package com.trusause.vip4.controller;

import com.trusause.vip4.service.IndexService;
import lombok.extern.slf4j.Slf4j;
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
import java.util.concurrent.CountDownLatch;

/**
 * @Author weicl
 * @Date 2022/6/21 下午5:49
 * @Version 1.0
 * @Description
 */
@Controller
@RequestMapping("/index")
@Slf4j
public class IndexController {

    @Autowired
    Redisson redisson;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    IndexService indexService;

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        log.info("主线程开始执行");
//        //第一种方式
//        indexService.joinMethod();

        //第二种方式
        indexService.countDownLatchMethod();
        log.info("主线程执行完毕");
        return "hello";
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
