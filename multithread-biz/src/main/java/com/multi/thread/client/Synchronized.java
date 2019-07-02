package com.multi.thread.client;

/**
 * @description:
 * @name: Synchronized
 * @author: Stars Hung
 * @date: 14:23 2019/5/17
 **/
public class Synchronized {

    public static void main(String[] args) {
        synchronized (Synchronized.class) {

        }
        m();
    }

    public static synchronized void m() {

    }
}
