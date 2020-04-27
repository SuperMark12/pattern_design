package com.dou.concurrent.test01synchronized;

/**
 * 当一个线程获取了某个对象的synchronized方法或者synchronized代码块时，其他线程访问该对象的该synchronized方法或者synchronized代码块将被阻塞
 */
class MyRunable implements Runnable {
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

public class Demo01 {
    public static void main(String[] args) {
        Runnable demo = new MyRunable();

        Thread t1 = new Thread(demo, "thread-1");
        Thread t2 = new Thread(demo, "thread-2");

        t1.start();
        t2.start();
    }
}
