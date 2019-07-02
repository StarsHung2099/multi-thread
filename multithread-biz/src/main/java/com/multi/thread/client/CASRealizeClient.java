package com.multi.thread.client;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @name: CASRealizeClient
 * @author: Stars Hung
 * @date: 13:44 2019/5/17
 **/
public class CASRealizeClient {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        CASRealizeClient casRealizeClient = new CASRealizeClient();
        List<Thread> threadList = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for(int j = 0; j < 100; j++){
            Thread t = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    casRealizeClient.count();
                    casRealizeClient.safeCount();
                }
            });
            threadList.add(t);
        }
        for(Thread thread : threadList){
            thread.start();
        }

        for(Thread t : threadList){
            try{
                t.join();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(casRealizeClient.i);
        System.out.println(casRealizeClient.atomicInteger.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicInteger.get();
            boolean sunc = atomicInteger.compareAndSet(i, ++i);
            if (sunc) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
