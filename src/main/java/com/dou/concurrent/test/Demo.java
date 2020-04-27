package com.dou.concurrent.test;

class MythreadStartAndRun extends Thread {
    public MythreadStartAndRun(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
};

public class Demo {
    public static void main(String[] args) {
        Thread mythread = new MythreadStartAndRun("mythread");

        System.out.println(Thread.currentThread().getName() + " call mythread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName() + " call mythread.start()");
        mythread.start();
    }
}
