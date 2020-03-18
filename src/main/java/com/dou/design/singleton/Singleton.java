package com.dou.design.singleton;

/**
 * 单例模式Singleton
 * 全局只有一个对象
 * 分为饿汉式和懒汉式
 */
public class Singleton {

    private Singleton() {}

    /**
     * 创建类的唯一实例,在类加载的时候创建，属于饿汉式
     */
    private static Singleton instance = new Singleton();

    /**
     * 提供一个方法获取实例
     */
    public static Singleton getInstance() {
        return instance;
    }
}
