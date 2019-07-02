package com.multi.thread.client;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @description: 通过管道输入/输出流在线程之间传输数据
 * @name: Piped
 * @author: Stars Hung
 * @date: 17:39 2019/5/17
 **/
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader reader = new PipedReader();
        out.connect(reader);
        Thread printThread = new Thread(new Print(reader), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while((receive = System.in.read()) != 1){
                out.write(receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }

    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
