package com.dou.concurrent.army;

public class KeyPersonThread extends Thread {

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println(getName() + "左突右击");
        }
        System.out.println(getName() + "结束战斗");
    }
}
