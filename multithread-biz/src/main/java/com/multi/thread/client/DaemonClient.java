package com.multi.thread.client;

import com.multi.thread.util.SleepUtils;
import com.sun.media.sound.DataPusher;

/**
 * @description:
 * @name: DaemonClient
 * @author: Stars Hung
 * @date: 15:27 2019/5/20
 **/
public class DaemonClient {
    public static void main(String[] args){
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try{
                SleepUtils.second(10L);
            }finally {
                System.out.println("DaemonThread finally run");
            }
        }


    }
}
