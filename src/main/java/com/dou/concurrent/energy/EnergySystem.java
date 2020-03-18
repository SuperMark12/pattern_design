package com.dou.concurrent.energy;

public class EnergySystem {
    //能量盒子，能量存贮的地方
    private final double[] energyBox;
    //对象锁
    private final Object lockObject = new Object();

    /**
     * 能量初始化
     * @param n
     * @param initialEnergy
     */
    public EnergySystem(int n, double initialEnergy) {
        this.energyBox = new double[n];
        for (int i=0; i<n; i++) {
            energyBox[i] = initialEnergy;
        }
    }

    /**
     * 能量转移
     * @param from 源头
     * @param to 终点
     * @param amount 每次转移量
     */
    public void energyTransfer(int from, int to, double amount) {
        synchronized (lockObject) {
//            if (energyBox[from] < amount) {
//                return;
//            }
            //while循环，保证条件不满足时任务都会被条件阻挡
            while (energyBox[from] < amount) {
                try {
                    //条件不满足，将当前线程放入Wait Set
                    lockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
            energyBox[from] -= amount;
            System.out.printf("从%d转移%10.2f单位能量到%d", from, amount, to);
            energyBox[to] += amount;
            System.out.printf("能量总和：%10.2f%n", getTotalEnergy());

            //唤醒线程
            lockObject.notifyAll();
        }

    }

    private double getTotalEnergy() {
        double sum = 0;
        for (int i=0; i<energyBox.length; i++) {
            sum = sum + energyBox[i];
        }
        return sum;
    }

    public int getBoxAmount() {
        return energyBox.length;
    }
}
