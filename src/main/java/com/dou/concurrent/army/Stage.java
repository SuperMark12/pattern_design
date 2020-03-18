package com.dou.concurrent.army;

public class Stage extends Thread {

    @Override
    public void run() {
        System.out.println("欢迎观看隋唐演义");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArmyRunable armyTaskOfSuiDynasty = new ArmyRunable();
        ArmyRunable armyTaskOfRevolt = new ArmyRunable();

        //创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");

        //启动线程
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠，大家专心观看军队厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当军队激战正酣，半路杀出个程咬金");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");

        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //关键人物
        mrCheng.start();

        //等待当前线程执行结束
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束，人民安居乐业！");
    }

    public static void main(String[] args) {
        Thread stage = new Stage();
        stage.start();
    }
}
