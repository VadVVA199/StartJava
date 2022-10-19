package com.startjava.lesson_2_3_4.robot;

public class JaegerTest {
    
    public static void main(String[] args) {
        Jaeger coyoteTango = new Jaeger();
        coyoteTango.setModelName("Coyote Tango");
        coyoteTango.setMark("Mark-1");
        coyoteTango.setOrigin("Japan");
        coyoteTango.setHeight(280f);
        coyoteTango.setWeight(2312f);
        coyoteTango.setSpeed(5);
        coyoteTango.setStrength(7);
        coyoteTango.setArmor(4);
        System.out.println("isDrift: " + coyoteTango.drift());
        System.out.println("scanKaiju: " + coyoteTango.scanKaiju());
        coyoteTango.move();
        System.out.println("speed - " + coyoteTango.getSpeed());
        coyoteTango.useVortexCannon();
        System.out.println(coyoteTango);

        Jaeger gipsyDanger = new Jaeger("Gipsy Danger", "Mark-3", "USA", 260f, 1980, 7, 8, 6);
        System.out.println("isDrift: " + gipsyDanger.drift());
        System.out.println("scanKaiju: " + gipsyDanger.scanKaiju());
        gipsyDanger.move();
        System.out.println("speed - " + gipsyDanger.getSpeed());
        gipsyDanger.useVortexCannon();
        System.out.println(gipsyDanger);
        coyoteTango.setSpeed(2);
        gipsyDanger.setSpeed(1);
        System.out.println(coyoteTango.getModelName() + ", speed: " + coyoteTango.getSpeed());
        System.out.println(gipsyDanger.getModelName() + ", speed: " + gipsyDanger.getSpeed());
    }
}