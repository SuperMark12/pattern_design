package com.dou.design.factory;

/**
 * 生成左偏分发型
 */
public class LeftHair implements HairInterface {

    @Override
    public void draw() {
        System.out.println("-----------左偏分发型---------------");
    }
}
