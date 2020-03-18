package com.dou.design.singleton;

/**
 * 懒汉模式
 * 区别：饿汉模式在加载类时比较慢，但运行时获取对象的速度比较快，线程安全
 *       懒汉模式在加载类时比较快，但运行时获取对象的速度比较慢，线程不安全
 */
public class Singleton2 {
    private Singleton2() {};

    /**
     * 创建类的唯一实例
     */
    private static Singleton2 instance;

    /**
     * 创建方法获取实例
     */
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
