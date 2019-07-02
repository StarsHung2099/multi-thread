package com.multi.thread.client;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @description:
 * @name: MultiThread
 * @author: Stars Hung
 * @date: 14:40 2019/5/20
 **/
public class MultiThread {

    public static void main(String[] args){
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfoList = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfoList){
            System.out.println("[".concat(threadInfo.getThreadId() + "").concat("] -- ").concat(threadInfo.getThreadName()));
        }
    }
}
