package com.dou.concurrent.volatileTest;

public class ThredTest {
    public static void main(String[] args) {

        Thread1 t1 = new Thread1("01");
        Thread1 t2 = new Thread1("02");
        t1.start();
        t2.start();

        //可以看出一共卖了200张票
    }
}

class Thread1 extends Thread {

    private int ticket = 10;

    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println("窗口:" + Thread.currentThread().getName() + ",卖了1个，剩余：" + (ticket--));
        }
    }
}
