package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private Player[] players;
    private int hiddenNumber;

    public GuessNumber(Player...args) {
        players = args;
    }

    public void start() {
        shuffle();
        printNamePlayer();
        clearPlayerAttempts();
        hiddenNumber = (int) (1 + Math.random() * 100);
        Scanner scanner = new Scanner(System.in); 
        Player player = players[0];
        while(true) {
            enterNumber(player, scanner);
            if (checkNumber(player)) {
                break;
            }
            calculateResultRounds(player);
            if (player.equals(players[0])) {
                player = players[1];
            } else if (player.equals(players[1])) {
                player = players[2];
            } else {
                player = players[0];
            }
        }
        calculateResultRounds(player);
        printPlayerNumbers();
    }

    private void shuffle() {
        for (int i = players.length - 1; i >= 1;i--) {
            Random rand = new Random();
            int j = rand.nextInt(i + 1);
            Player temp = players[i];
            players[i] = players[j];
            players[j] = temp;
        }
    }

    private void printNamePlayer() {
        System.out.println("\tИгра началась");
        int i = 1;
        for (Player player : players) {
            System.out.println("\tИмя игрока : " + player.getName() + ", игрок номер: " + i);
            i++;
        }
    }

    private void clearPlayerAttempts() {
        for (Player player : players) {
            player.clearAttempts();
        }
    }

    private void enterNumber(Player player, Scanner scanner) {
        player.setAttempt(1);
        boolean testNumber = false;
        while (!testNumber) {
            try {
                System.out.print("Игрок " + player.getName() + " введите ваше число: ");
                player.addNumber(scanner.nextInt());
                testNumber = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean checkNumber(Player player) {
        int numPlayer = player.getNumbers()[player.getAttempt() - 1];
        String playerName = player.getName();
        if (numPlayer == hiddenNumber) {
            System.out.println("Игрок: " + playerName + " угадал число " + numPlayer + " c " +
                    player.getAttempt() + "-ой попытки");
            return true;
        }
        System.out.println("Число: " + numPlayer + " игрока: " +
                playerName + (numPlayer > hiddenNumber ? " больше " : " меньше ") + "задуманного числа компьютера");
        if (player.getAttempt() >= 10) {
            System.out.println("У " + playerName + " закончились попытки");
            return checkEndAttempts();
        }
        return false;
    }

    private boolean checkEndAttempts() {
        for (Player player : players) {
            if (player.getAttempt() < 10) {
                return false;
            }
        }
        return true;
    }

    private void calculateResultRounds(Player player) {
        if (player.getAttempt() % 3 == 0 || player.getAttempt() == 10) {
            player.setMinDifferenceHiddenNumber(calcaulateResultGuessingNumber(player.getNumbers()));
            if (player.equals(players[players.length - 1])) {
                printWinners(calcaulateWinners());
            }
        }
    }

    private int calcaulateResultGuessingNumber(int... args) {
        int minDiffHiddNumber = 100;
        for (int number : args) {
            int numberModuleDifference = Math.abs(hiddenNumber - number);
            if (minDiffHiddNumber > numberModuleDifference) {
                minDiffHiddNumber = numberModuleDifference;
            }
        }
        return minDiffHiddNumber;
    }

    private Player[] calcaulateWinners() {
        Player[] winners = new Player[players.length];
        if (players[0].getMinDifferenceHiddenNumber() > players[1].getMinDifferenceHiddenNumber()) {
            winners[0] = players[1];
        } else if (players[0].getMinDifferenceHiddenNumber() < players[1].getMinDifferenceHiddenNumber()) {
            winners[0] = players[0];
        } else {
            winners[0] = players[0];
            winners[1] = players[1];
        }
        if (players[0].getMinDifferenceHiddenNumber() > players[2].getMinDifferenceHiddenNumber()) {
            winners[0] = players[2];
        } else if (players[0].getMinDifferenceHiddenNumber() == players[2].getMinDifferenceHiddenNumber()) {
            int index = 1;
            winners[winners[1] == null ? index : index + 1] = players[2];
        }
        return winners;
    }

    private void printWinners(Player[] winners) {
        System.out.println("Победители по " + winners[0].getAttempt() + " раунду" );
        for (Player player : winners) {
            if (!(player == null)) {
                System.out.print(player.getName() + " ");
            }
        }
        System.out.println();
    }

    private void printPlayerNumbers() {
        for (Player player : players) {
            System.out.print(player.getName());
            for (int currentNum : player.getNumbers()) {
                System.out.print(" " + currentNum);
            }
            System.out.println();
        }
    }
}


