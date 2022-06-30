package com.trusause.vip4.service;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * @Author weicl
 * @Date 2022/6/29 下午4:35
 * @Version 1.0
 * @Description
 */

@Service
@Slf4j
public class IndexService {

    public void joinMethod() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    log.info("线程1睡眠5s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程1执行完了");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    Thread.sleep(3000);
                    log.info("线程2睡眠5s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程2执行完了");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程3执行完了");
            }
        });

        //threa1、thread2、thread3的start顺序无所谓。实际是按照thread1.join();thread2.join();的顺序去执行的，也就是thread1执行完之后再执行thread2，thread2执行完之后再执行thread3。
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void countDownLatchMethod() {
        CountDownLatch countDownLatch=new CountDownLatch(3);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    log.info("线程1睡眠5s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程1执行完了");
                countDownLatch.countDown();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    Thread.sleep(3000);
                    log.info("线程2睡眠5s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程2执行完了");
                countDownLatch.countDown();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程3执行完了");
                countDownLatch.countDown();
            }
        });

        //threa1、thread2、thread3的start顺序无所谓。实际是按照thread1.join();thread2.join();的顺序去执行的，也就是thread1执行完之后再执行thread2，thread2执行完之后再执行thread3。
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
