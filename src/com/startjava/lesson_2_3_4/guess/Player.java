package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private String name;
    private int number;
    private int[] numbersAttempts;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

     public int[] getNumberAttempts() {
        int endNumbers = numbersAttempts.length;
        for (int i = 0; i < numbersAttempts.length; i++) {
            if (numbersAttempts[i] == 0) {
                endNumbers = i;
                break;
            }
        }
        return Arrays.copyOf(numbersAttempts, endNumbers);
    }

    public void setNumberAttempts(int numberAttempt) {
        if (numbersAttempts == null) {
            numbersAttempts = new int[10];
            numbersAttempts[0] = numberAttempt;
        } else {
            for (int i = 0; i < numbersAttempts.length; i++) {
                if (numbersAttempts[i] == 0) {
                    numbersAttempts[i] = numberAttempt;
                    break;
                }
            }
        }
    }

    public void setNumbersAttemptsNull() {
        if (numbersAttempts != null) {
            Arrays.fill(numbersAttempts, 0, getNumberAttempts().length, 0);
        }
    }
}