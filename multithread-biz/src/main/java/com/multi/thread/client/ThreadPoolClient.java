package com.multi.thread.client;

import java.util.concurrent.*;

/**
 * @description:
 * @name: ThreadPoolClient
 * @author: Stars Hung
 * @date: 15:09 2019/6/20
 **/
public class ThreadPoolClient {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(1024), new ThreadPoolExecutor.AbortPolicy());
    }
}
