package com.dou.concurrent.waitandnotify.test;

public class Producer extends Thread {
    //每次生产的数量
    private int num;

    //所属的仓库
    public AbstractStorage abstractStorage;

    public Producer(AbstractStorage abstractStorage) {
        this.abstractStorage = abstractStorage;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        produce(num);
    }

    public void produce(int num) {
        abstractStorage.produce(num);
    }
}
