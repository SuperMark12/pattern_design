package com.dou.concurrent.waitandnotify;

public class WaitTimeoutTest {
    public static void main(String[] args) {
        ThreadB t1 = new ThreadB("t1");

        synchronized (t1) {
            try {
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                System.out.println(Thread.currentThread().getName() + " call wait ");
                t1.wait(3000);

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadB extends Thread {
    public ThreadB(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " run");
            //死循环，不断运行
            while (true)
                ;
        }
    }
}
