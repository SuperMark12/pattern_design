package com.dou.design.factory;

public class test {

    public static void main(String[] args) {
        //每次添加新产品，需要将产品类告知客户端
        HairInterface left = new LeftHair();
        HairInterface right = new RightHair();

//        left.draw();
//        right.draw();

        //工厂方法生成发型
        HairFactory factory = new HairFactory();
        HairInterface left1 = factory.getHair("left");
        HairInterface right1 = factory.getHair("right");
//        right1.draw();
//        left1.draw();

        HairInterface left3 = factory.getHairByClass("com.dou.design.factory.LeftHair");
//        left3.draw();

        HairInterface middle = factory.getHairByClassKey("middle");
        middle.draw();

        PersionFactory factory1 = new MCFactory();
        Boy boy = factory1.getBoy();
        boy.drawMan();

        PersionFactory factory2 = new HNFactory();
        Girl girl = factory2.getGirl();
        girl.drawWoman();

    }



}
