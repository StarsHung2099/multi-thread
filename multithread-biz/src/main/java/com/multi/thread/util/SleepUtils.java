package com.multi.thread.util;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @name: SleepUtils
 * @author: Stars Hung
 * @date: 15:30 2019/5/20
 **/
public class SleepUtils {

    public static void second(Long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
