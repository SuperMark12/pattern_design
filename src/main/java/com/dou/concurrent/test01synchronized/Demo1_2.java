package com.dou.concurrent.test01synchronized;

class Mythread extends Thread {
    public Mythread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

public class Demo1_2 {
    public static void main(String[] args) {
        Thread t1 = new Mythread("thread-1");
        Thread t2 = new Mythread("thread-2");

        t1.start();
        t2.start();
    }
}
