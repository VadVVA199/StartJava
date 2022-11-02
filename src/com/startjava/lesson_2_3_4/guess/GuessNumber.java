package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int hiddenNumber;
    private Player currentPlayer;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void start() {
        System.out.println("\tИгра началась:\n\tИгрок первый: " + player1.getName() + 
                "\n\tИгрок второй: " + player2.getName());
        player1.clearAttempts();
        player2.clearAttempts();
        hiddenNumber = (int) (1 + Math.random() * 100);
        System.out.println("\tслучайное число: " + hiddenNumber);
        Scanner scanner = new Scanner(System.in); 
        currentPlayer = player2;
        while(true) {
            enterNumber(currentPlayer, scanner);
            if (checkNumber(currentPlayer) == 0) {
                break;
            }
        }
        printPlayerNumbers();
    }

    private void enterNumber(Player currentPlayer, Scanner scanner) {
        String playerName = currentPlayer.getName();
        System.out.print("Игрок " + playerName + " введите ваше число: ");
        currentPlayer.setAttempt(1);
        currentPlayer.addNumber(scanner.nextInt());
    }

    private int checkNumber(Player currentPlayer) {
        int numPlayer = currentPlayer.getNumbers()[currentPlayer.getAttempt() - 1];
        String playerName = currentPlayer.getName();
        if (numPlayer == hiddenNumber) {
            System.out.println("Игрок: " + playerName + " угадал число " + numPlayer + " c " +
                    currentPlayer.getAttempt() + "-ой попытки");
            return 0;
        }
        if (numPlayer > hiddenNumber) {
            System.out.println("Число: " + numPlayer + " игрока: " +
                    playerName + " больше задуманного числа компьютера");
        } else {
            System.out.println("Число: " + numPlayer + " игрока: " +
                    playerName + " меньше задуманного числа компьютера");
        }
        if (currentPlayer.getAttempt() >= 2) {
            System.out.println("У " + playerName + " закончились попытки");
            if (player1.getAttempt() >= 2 && player2.getAttempt() >= 2) {
                return 0;
            }
        }
        setCurrentPlayer(currentPlayer == player2 ? player1 : player2);
        return 1;
    }

    private void printPlayerNumbers() {
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getName());
            for (int j = 0; j < players[i].getNumbers().length; j++) {
                System.out.print(" " + players[i].getNumbers()[j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}


