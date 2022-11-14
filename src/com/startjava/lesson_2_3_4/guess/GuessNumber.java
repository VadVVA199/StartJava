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
        printParticipants();
        clearPlayerAttempts();
        clearNumbersWins();
        clearNumbersWholeGame();
        hiddenNumber = (int) (1 + Math.random() * 100);
        Scanner scanner = new Scanner(System.in);
        for (int round = 1; round <= 3; round++) {
            boolean outRoundAttempts = true;
            while (outRoundAttempts) {
                for (Player player : players) {
                    enterNumber(player, scanner);
                    if (checkNumber(player, round)) {
                        printPlayerNumbers();
                        return;
                    }
                    checkEndAttempts(player);
                }
                calculateRoundWins();
                outRoundAttempts = checkEndAttemptsInRound();
            }
            printRoundWins(round);
            copyNumbersWholeGamePlayers();
            clearPlayerAttempts();
            System.out.println();
        }
        printPlayerNumbersWholeGame();
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

    private void printParticipants() {
        System.out.println("\tИгра началась");
        for (int i = 0; i < players.length; i++) {
            System.out.println("\tИмя игрока : " + players[i].getName() + ", игрок номер: " + (i + 1));
        }
    }

    private void copyNumbersWholeGamePlayers() {
        for (Player player : players) {
            player.copyNumbersWholeGame();
        }
    }

    private void clearPlayerAttempts() {
        for (Player player : players) {
            player.clearAttempts();
        }
    }

    private void clearNumbersWins() {
        for (Player player : players) {
            player.clearNumberWins();
        }
    }

    private void clearNumbersWholeGame() {
        for (Player player : players) {
            player.clearNumbersWholeGame();
        }
    }

    private void enterNumber(Player player, Scanner scanner) {
        while (true) {
            int number = 0;
            try {
                System.out.print("Игрок " + player.getName() + " введите ваше число: ");
                number = scanner.nextInt();
                player.addNumber(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ", ваше значение " + number + ". Интервал значений " +
                        "должен быть от 1 до 100 включительно");
            }
        }
    }

    private boolean checkNumber(Player player, int round) {
        int number = player.getNumbers()[player.getAttempt() - 1];
        String name = player.getName();
        if (number == hiddenNumber) {
            System.out.println("Игрок: " + name + " угадал число " + number + " c " +
                    player.getAttempt() + "-ой попытки, " + round + "-го раунда");
            return true;
        }
        String compareResult = number > hiddenNumber ? " больше " : " меньше ";
        System.out.println("Число: " + number + " игрока: " + name + " " +
                compareResult + " задуманного числа компьютера");
        return false;
    }

    private void checkEndAttempts(Player player) {
        if (player.getAttempt() >= 10) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
    }

    private void calculateRoundWins () {
        Player[] winners = new Player[players.length];
        System.arraycopy(players, 0, winners, 0, players.length);
        for (int i = 0; i < winners.length; i++) {
            for (int j = 0; j < winners.length - 1; j++) {
                int differenceHiddenNumberAndNumberOnePlayer = Math.abs(hiddenNumber -
                        winners[j].getNumbers()[winners[j].getAttempt() - 1]);
                int differenceHiddenNumberAndNumberTwoPlayer = Math.abs(hiddenNumber -
                        winners[j + 1].getNumbers()[winners[j].getAttempt() - 1]);
                if (differenceHiddenNumberAndNumberOnePlayer > differenceHiddenNumberAndNumberTwoPlayer) {
                    Player temp = winners[j];
                    winners[j] = winners[j + 1];
                    winners[j + 1] = temp;
                }
            }
        }
        int index = 0;
        do {
            for (Player player : players) {
                if (winners[index].equals(player)) {
                    player.incNumberWins();
                }
            }
            if (index == winners.length - 1) {
                break;
            }
            index++;
        } while (Math.abs(hiddenNumber - winners[0].getNumbers()[winners[0].getAttempt() - 1]) ==
                Math.abs(hiddenNumber - winners[index].getNumbers()[winners[index].getAttempt() - 1]));
    }

    private boolean checkEndAttemptsInRound() {
        return players[players.length - 1].getAttempt() != 10 ? true : false;
    }

    private void printRoundWins ( int round){
        Player[] winners = new Player[players.length];
        System.out.println("Результа по " + round + " раунду");
        System.arraycopy(players, 0, winners, 0, players.length);
        for (int i = 0; i < winners.length; i++) {
            for (int j = 0; j < winners.length - 1; j++) {
                if (winners[j].getNumberWins() < winners[j + 1].getNumberWins()) {
                    Player temp = winners[j];
                    winners[j] = winners[j + 1];
                    winners[j + 1] = temp;
                }
            }
        }
        int index = 0;
        do {
            for (Player player : players) {
                if (winners[index].equals(player)) {
                    System.out.print(player.getName() + " ");
                }
            }
            if (index == winners.length - 1) {
                break;
            }
            index++;
        } while (winners[0].getNumberWins() == winners[index].getNumberWins());
    }

    private void printPlayerNumbers() {
        for (Player player : players) {
            System.out.print(player.getName());
            for (int currentNumber : player.getNumbers()) {
                if (currentNumber != 0) {
                    System.out.print(" " + currentNumber);
                }
            }
            System.out.println();
        }
    }

    private void printPlayerNumbersWholeGame() {
        for (Player player : players) {
            System.out.print(player.getName());
            for (int currentNumber : player.getNumbersWholeGame()) {
               if (currentNumber != 0) {
                   System.out.print(" " + currentNumber);
               }
            }
            System.out.println();
        }
    }
}


