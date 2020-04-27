package com.dou.concurrent.test01synchronized;

/**
 * 01: 当一个线程获取了某个对象的synchronized方法或者代码块时，其他线程可以访问该对象的非同步代码块
 * 02：当一个线程获取了某个对象的synchronized方法或者代码块时，其他线程访问该对象的其他synchronized方法或者代码块时将被阻塞
 *
 */
class Count {
    public void synMethod() {
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

    public void nonSynMethod() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " loop" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 加锁
         */
//        synchronized (this) {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    Thread.sleep(100);
//                    System.out.println(Thread.currentThread().getName() + " loop" + i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}

public class Demo2 {
    public static void main(String[] args) {
        final Count count = new Count();
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.synMethod();
                    }
                }
        );
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.nonSynMethod();
                    }
                }
        );

        t1.start();
        t2.start();
    }
}
