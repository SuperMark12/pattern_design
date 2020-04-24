package com.dou.concurrent.volatileTest;

import java.util.concurrent.TimeUnit;

public class RunnableTest {

    public static void main(String[] args) {

        Runnable1 r1 = new Runnable1();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

//        new Thread(()->{
//            r1.run();
//        }).start();
//
//        new Thread(()->{
//            r1.run();
//        }).start();
//
//        new Thread(()->{
//            r1.run();
//        }).start();
        //2个窗口一共卖了100张
    }
}

class Runnable1 implements Runnable
{
    public int ticket = 10;
    @Override
    public void run() {
        while(ticket > 0)
        {
            System.out.println("窗口:"+Thread.currentThread().getName()+",卖了1个，剩余："+(ticket--));
        }
    }
}
