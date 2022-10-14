package com.startjava.lesson_2_3.person;

public class Person {
    
    String name = "Дмитрий";
    String sex = "Мужской";
    int age = 35;
    int height = 180;
    int weight = 95;

    void go() {
        System.out.println("\tЧеловек идет");
    }

    void sit() {
        System.out.println("\tЧеловек сидит");
    }

    void run() {
        System.out.println("\tЧеловек бежит");
    }

    String say() {
        return "\tЧеловек говорит";
    }

    boolean learnJava() {
        System.out.println("\tЧеловек учит Java");
        return true;
    }
}