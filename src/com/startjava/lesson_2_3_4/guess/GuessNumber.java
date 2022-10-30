package com.startjava.lesson_2_3_4.guess;

import java.lang.reflect.Array;
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
        player1.setNumbersAttemptsNull();
        player2.setNumbersAttemptsNull();
        hiddenNumber = (int) (1 + Math.random() * 100);
        System.out.println("\tслучайное число: " + hiddenNumber);
        Scanner scanner = new Scanner(System.in); 
        Player currentPlayer = player2;
        while(true) {
            String playerName = currentPlayer.getName();
            System.out.print("Игрок " + playerName + " введите ваше число: ");
            currentPlayer.setNumber(scanner.nextInt());
            int numPlayer = currentPlayer.getNumber();
            currentPlayer.setNumberAttempts(numPlayer);
            if (numPlayer == hiddenNumber) {
                System.out.println("Игрок: " + playerName + " угадал число " + numPlayer + " c " +
                        currentPlayer.getNumberAttempts().length + "-ой попытки");
                break;
            } else if (numPlayer > hiddenNumber) {
                System.out.println("Число: " + numPlayer + " игрока: " + 
                        playerName + " больше задуманного числа компьютера");
            } else if (numPlayer < hiddenNumber) {
                System.out.println("Число: " + numPlayer + " игрока: " + 
                        playerName + " меньше задуманного числа компьютера");
            }
            if (currentPlayer.getNumberAttempts().length >= 10) {
                System.out.println("У " + playerName + " закончились попытки");
                currentPlayer = currentPlayer == player2 ? player1 : player2;
                if (currentPlayer.getNumberAttempts().length >= 10) {
                    break;
                }
            } else {
                currentPlayer = currentPlayer == player2 ? player1 : player2;
            }
        }
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getName());
                for (int j = 0; j < players[i].getNumberAttempts().length; j++) {
                    System.out.print(" " + players[i].getNumberAttempts()[j]);
                }
                System.out.println();
        }
        System.out.println();
    }
}


