package com.dou.concurrent.waitandnotify.test;

public class Consumer extends Thread {
    //每次消费的产品数量
    private int num;

    //所在仓库
    private AbstractStorage abstractStorage;

    public Consumer(AbstractStorage abstractStorage) {
        this.abstractStorage = abstractStorage;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void consume(int num) {
        abstractStorage.consume(num);
    }

    @Override
    public void run() {
        consume(num);
    }
}
