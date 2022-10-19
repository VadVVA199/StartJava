package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setSex("самка");
        wolf.setNickname("альма");
        wolf.setWeight(35);
        wolf.setAge(3);
        wolf.setColor("серо-бурая");
        System.out.println("\tВолк кличка: " + wolf.getNickname() + ", пол: " + wolf.getSex() +
                ", вес: " + wolf.getWeight() + ", возраст: " + wolf.getAge() + 
                ", окрас: " + wolf.getColor());
        wolf.go();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    } 
}