package com.dou.concurrent.energy;

public class EnergyTransferTask implements Runnable {

    private EnergySystem energySystem;

    private int fromBox;

    private double maxAmount;

    private int DELAY = 10;

    public EnergyTransferTask(EnergySystem energySystem, int fromBox, double maxAmount) {
        this.energySystem = energySystem;
        this.fromBox = fromBox;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        while (true) {
            int toBox = (int) (energySystem.getBoxAmount()*Math.random());
            double amount = maxAmount*Math.random();
            energySystem.energyTransfer(fromBox, toBox, amount);
            try {
                Thread.sleep((int) (DELAY*Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
