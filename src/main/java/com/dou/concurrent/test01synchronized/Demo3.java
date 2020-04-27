package com.dou.concurrent.test01synchronized;

/**
 * 同步代码块比同步方法效率高
 */
public class Demo3 {
    public synchronized void synMethod() {
        for (int i = 0; i<1000000; i++){
            ;
        }
    }

    public void synBlock() {
        synchronized (this) {
            for (int i=0; i<1000000; i++) {
                ;
            }
        }
    }

    public static void main(String[] args) {
        Demo3 demo = new Demo3();

        long start, diff;
        start = System.currentTimeMillis();
        demo.synMethod();
        diff = System.currentTimeMillis() - start;
        System.out.println("synMethod() : " + diff);

        start = System.currentTimeMillis();
        demo.synBlock();
        diff = System.currentTimeMillis() - start;
        System.out.println("synBlock() : " + diff);
    }
}
