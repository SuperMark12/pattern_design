package com.dou.config.annotation;

public class AnnotationTest {

    //如下注解可以抑制过期方法的警告
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        //该方法已经过时
        System.runFinalizersOnExit(true);
    }

    //如下注解表示该方法已经废弃掉了
    @Deprecated
    public static void sayHello() {
        System.out.println("Hi, 小花猫");
    }

    //重写（覆盖）
    @Override
    public String toString() {
        return "小花猫";
    }
}
