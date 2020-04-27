package com.dou.concurrent.waitandnotify;

public class NotifyAllTest {
    private static Object object = new Object();

    public static void main(String[] args) {
        ThreadC t1 = new ThreadC("t1");
        ThreadC t2 = new ThreadC("t2");
        ThreadC t3 = new ThreadC("t3");

        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println(Thread.currentThread().getName() + " sleep(3000)");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " notifyAll()");
            object.notifyAll();
        }
    }


    static class ThreadC extends Thread {
        public ThreadC(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait");

                    object.wait();

                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}


