package com.dou.concurrent.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementTestDemo {

    private static int count = 0;
    private static Counter counter = new Counter();
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static volatile int countVolatile = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        count++;
                        counter.increment();
                        atomicInteger.getAndIncrement();
                        countVolatile++;
                    }
                }
            }.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("static count: " + count);
        System.out.println("Counter: " + counter.getValue());
        System.out.println("AtomicInteger: " + atomicInteger.intValue());
        System.out.println("countVolatile: " + countVolatile);
    }


    static class Counter {
        private int value;

        public synchronized int getValue() {
            return value;
        }

        public synchronized int increment() {
            return ++value;
        }

        public synchronized int decrement() {
            return --value;
        }
    }
}
