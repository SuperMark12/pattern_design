package com.dou.concurrent.test;

public class JavaThreadAnywhere {

    public static void main(String[] args) {
       //获取当前线程
        Thread currentThread = Thread.currentThread();

        //获取当前线程名称
        String currentThreadName = currentThread.getName();

        System.out.printf("The main method was executed by thread: %s%n", currentThreadName);

        Helper helper = new Helper("Java Thread AnyWhere");

//        helper.run();

        Thread helpThread = new Thread(helper);
        helpThread.start();
    }

    static class Helper implements Runnable {
        private final String message;

        public Helper(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            doSomething();
        }

        private void doSomething() {
            //获取当前线程
            Thread currentThread = Thread.currentThread();

            //获取当前线程的线程名称
            String currentThreadName = currentThread.getName();

            System.out.printf("The doSomething method was executed by thread: %s%n", currentThreadName);
            System.out.println("Do something with " + message);
        }
    }
}
