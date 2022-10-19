package com.startjava.lesson_2_3_4.animal;

public class Wolf {
    
    private String sex;
    private String niсkname;
    private int weight;
    private int age;
    private String color;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return niсkname;
    }

    public void setNickname(String niсkname) {
        this.niсkname = niсkname;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 8) {
            System.out.println("\tНекорректный возраст");
        } else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void go() {
        System.out.println("\tИдет");
    }

    public void sit() {
        System.out.println("\tСидит");
    }

    public void run() {
        System.out.println("\tБежит");
    }

    public void howl() {
        System.out.println("\tВоет");
    }

    public void hunt() {
        System.out.println("\tОхотится");
    }
}