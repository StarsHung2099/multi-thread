package com.multi.thread.client;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @description:
 * @name: ThreadMethodClient
 * @author: Stars Hung
 * @date: 14:56 2019/6/20
 **/
public class ThreadMethodClient {

    public static void main(String[] args){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程中....");
            }
        });
        t.run();
        System.out.println("线程外");
    }
}
