package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private String name;
    private int[]numbers;
    private int attempt;

    public Player(String name) {
        this.name = name;
        this.numbers = new int[10];
    }

    public String getName() {
        return name;
    }

     public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public void addNumber(int numberAttempt) {
        this.numbers[attempt - 1] = numberAttempt;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt += attempt;
    }

    public void clearAttempts() {
        if (numbers != null) {
            Arrays.fill(numbers, 0, getAttempt(), 0);
            attempt = 0;
        }
    }
}