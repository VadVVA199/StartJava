package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private final int[] numbers;
    private int attempt;
    private int numberWins;
    private final int[] numbersWholeGame = new int[GuessNumber.NUMBER_ATTEMPTS];

    public Player(String name) {
        this.name = name;
        this.numbers = new int[GuessNumber.NUMBER_ATTEMPTS];
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public void addNumber(int number) {
        if (number <= 0 || number > 100) {
            throw new IllegalArgumentException("Ошибка, число не в заданном диапазоне");
        }
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

    public int getNumberWins() {
        return numberWins;
    }

    public void incNumberWins() {
        numberWins++;
    }

    public void clearNumberWins() {
        numberWins = 0;
    }

    public int[] getNumbersWholeGame(){
        return numbersWholeGame;
    }
    public void copyNumbersWholeGame() {
        System.arraycopy(numbers, 0, numbersWholeGame, 0, numbers.length);
    }

    public void clearNumbersWholeGame() {
        Arrays.fill(numbersWholeGame, 0, GuessNumber.NUMBER_ATTEMPTS - 1, 0);
    }
}