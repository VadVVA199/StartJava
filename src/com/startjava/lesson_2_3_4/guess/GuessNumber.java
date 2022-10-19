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
        hiddenNumber = (int) (1 + Math.random() * 100);
        System.out.println("\tслучайное число: " + hiddenNumber);
        Scanner scanner = new Scanner(System.in); 
        Player currentPlayer = player2;
        while(true) {
            String playerName = currentPlayer.getName();
            System.out.print("Игрок " + playerName + " введите ваше число: ");
            currentPlayer.setNumber(scanner.nextInt());
            int numPlayer = currentPlayer.getNumber();
            if (numPlayer == hiddenNumber) {
                System.out.println("Игрок: " + playerName + " выиграл");
                break;
            } else if (numPlayer > hiddenNumber) {
                System.out.println("Число: " + numPlayer + " игрока: " + 
                        playerName + " больше задуманного числа компьютера");
            } else if (numPlayer < hiddenNumber) {
                System.out.println("Число: " + numPlayer + " игрока: " + 
                        playerName + " меньше задуманного числа компьютера");
            }
            currentPlayer = currentPlayer == player2 ? player1 : player2;
        }
    }
}


