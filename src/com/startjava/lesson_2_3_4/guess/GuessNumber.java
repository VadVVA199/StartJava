package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int hiddenNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        System.out.println("\tИгра началась:\n\tИгрок первый: " + player1.getName() + 
                "\n\tИгрок второй: " + player2.getName());
        player1.clearAttempts();
        player2.clearAttempts();
        hiddenNumber = (int) (1 + Math.random() * 100);
        Scanner scanner = new Scanner(System.in); 
        Player player = player2;
        while(true) {
            enterNumber(player, scanner);
            if (checkNumber(player)) {
                break;
            }
            player = player == player2 ? player1 : player2;
        }
        printPlayerNumbers(player1);
        printPlayerNumbers(player2);
    }

    private void enterNumber(Player player, Scanner scanner) {
        System.out.print("Игрок " + player.getName() + " введите ваше число: ");
        player.addNumber(scanner.nextInt());
    }

    private boolean checkNumber(Player player) {
        int numPlayer = player.getNumbers()[player.getAttempt() - 1];
        String playerName = player.getName();
        if (numPlayer == hiddenNumber) {
            System.out.println("Игрок: " + playerName + " угадал число " + numPlayer + " c " +
                    player.getAttempt() + "-ой попытки");
            return true;
        }
        if (numPlayer > hiddenNumber) {
            System.out.println("Число: " + numPlayer + " игрока: " +
                    playerName + " больше задуманного числа компьютера");
        } else {
            System.out.println("Число: " + numPlayer + " игрока: " +
                    playerName + " меньше задуманного числа компьютера");
        }
        if (player.getAttempt() >= 10) {
            System.out.println("У " + playerName + " закончились попытки");
            return checkEndAttempts(player1, player2);
        }
        return false;
    }

    private boolean checkEndAttempts(Player... args) {
        for (Player player : args) {
            if (player.getAttempt() < 10) {
                return false;
            }
        }
        return true;
    }

    private void printPlayerNumbers(Player player) {
        System.out.print(player.getName());
        for (int currentNum : player.getNumbers()) {
            System.out.print(" " + currentNum);
        }
        System.out.println();
    }
}


