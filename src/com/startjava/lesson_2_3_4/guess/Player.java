package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private String name;
    private int[] numbers;
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

    public void addNumber(int number) {
        attempt++;
        numbers[attempt - 1] = number;
    }

    public int getAttempt() {
        return attempt;
    }

    public void clearAttempts() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
    }
}