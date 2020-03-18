package com.dou.concurrent.army;

public class ArmyRunable implements Runnable {

    //保证线程可以正确的读取其他线程写入的值
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始进攻");

        while (keepRunning) {
            for (int i=1; i<=5; i++) {
                System.out.println(Thread.currentThread().getName() + "进攻对方[" + i + "]");
                //让出处理器时间
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "进攻结束");
    }
}
