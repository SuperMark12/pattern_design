package com.dou.concurrent.test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RaceConditionDemo {

    public static void main(String[] args) {
        //客户端线程数
        int numberOfThreads = args.length > 0 ? Short.valueOf(args[0]) : Runtime.getRuntime().availableProcessors();
        Thread[] workerThreads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            workerThreads[i] = new WorkerThread(i, 10);
        }

        //待所有线程创建完毕后，再一次性将其启动，以便这些线程能够尽可能地在同一时间内运行
        for (Thread ct : workerThreads) {
            ct.start();
        }

    }

    //模拟业务线程
    static class WorkerThread extends Thread {
        private final int requestCount;

        public WorkerThread(int id, int requestCount) {
            super("worker-" + id);
            this.requestCount = requestCount;
        }

        @Override
        public void run() {
            int i = requestCount;
            String requestID;
            RequestIDGenerator requestIDGenerator = RequestIDGenerator.getInstance();
            while (i-- > 0) {
                //生成request ID
                requestID = requestIDGenerator.nextID();
                processRequest(requestID);
            }
        }

        //模拟请求处理
        private void processRequest(String requestID) {
            //模拟请求处理耗时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s got requestID: %s %n", Thread.currentThread().getName(), requestID);
        }
    }

}
//REQUEST ID 生成器
final class RequestIDGenerator {
    /**
     * 保存该类的唯一实例
     */
    private final static RequestIDGenerator instance = new RequestIDGenerator();
    private final static short SEQ_UPPER_LIMIT = 999;
    private short sequence = -1;

    //私有构造器
    private RequestIDGenerator() {
        //nothing to do
    }

    /**
     * 生成循环递增序列
     */
    public short nextSequence() {
        if (sequence >= SEQ_UPPER_LIMIT) {
            sequence = 0;
        } else {
            sequence++;
        }
        return sequence;
    }

    /**
     * 生成一个新的request ID
     */
    public String nextID() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        DecimalFormat decimalFormat = new DecimalFormat("000");

        //生成请求序列号
        short sequenceNo = nextSequence();

        return timestamp + " " + decimalFormat.format(sequenceNo);
    }

    /**
     * 返回该类的唯一实例
     */
    public static RequestIDGenerator getInstance() {
        return instance;
    }
}
