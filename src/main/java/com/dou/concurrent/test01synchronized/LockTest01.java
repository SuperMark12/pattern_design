package com.dou.concurrent.test01synchronized;

/**
 * 实例锁：锁在某一个实例对象上。如果该类是单例，那么该锁也是全局锁的概念。实例锁对应的就是synchronized关键字
 * 全局锁：该锁针对的是类，无论实例多少个对象，那么线程都共享该锁。全局锁对应的就是static synchronized(或者是锁在该类的class或者classloader对象上)
 */
class Something {
    public synchronized void isSyncA() {
        for (int i=0; i<5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ": isSyncA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void isSyncB() {
        for (int i=0; i<5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ": isSyncB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static synchronized void cSyncA() {
        for (int i=0; i<5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ": cSyncA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void cSyncB() {
        for (int i=0; i<5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ": cSyncB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class LockTest01 {
    Something x = new Something();
    Something y = new Something();

    //比较x.isSyncA() 与 x.isSyncB()
    private void test1() {
        Thread t1= new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }
        , "t11");

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncB();
                    }
                }
        ,"t12");

        t1.start();
        t2.start();
    }

    //比较x.isSyncA() 与 y.isSyncA()
    private void test2() {
        Thread t1= new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }
        ,"t21");

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        y.isSyncA();
                    }
                }
        ,"t22");

        t1.start();
        t2.start();
    }

    //比较x.cSyncA() 与 y.cSyncB()
    private void test3() {
        Thread t1= new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.cSyncA();
                    }
                }
        ,"t31");

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        y.cSyncB();
                    }
                }
        ,"t32");

        t1.start();
        t2.start();
    }

    //比较x.isSyncA() 与 Something.cSyncA()
    private void test4() {
        Thread t1= new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }
                ,"t41");

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Something.cSyncA();
                    }
                }
                ,"t42");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        LockTest01 demo = new LockTest01();
//        demo.test1();
//        demo.test2();
//        demo.test3();
        demo.test4();
    }


}
