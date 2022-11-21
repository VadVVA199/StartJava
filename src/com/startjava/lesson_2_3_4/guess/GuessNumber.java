package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static final int  NUMBER_ATTEMPTS = 10;
    private static final int NUMBER_ROUNDS = 3;
    private final Player[] players;
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
        System.out.println("Задуманное число " + hiddenNumber);
        Scanner scanner = new Scanner(System.in);
        for (int round = 1; round <= NUMBER_ROUNDS; round++) {
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
                outRoundAttempts = checkEndAttemptsInRound();
            }
            calculateRoundWins();
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
        if (player.getAttempt() >= NUMBER_ATTEMPTS) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
    }

    private void calculateRoundWins () {
        Player[] winners = new Player[players.length];
        int minimumDifferenceHiddenNumberAndNumber = 100;
        for (Player player : players) {
           int[] numbers = player.getNumbers();
           for (int number : numbers) {
               int differenceHiddenNumberAndNumber = Math.abs(hiddenNumber - number);
               if (minimumDifferenceHiddenNumberAndNumber > differenceHiddenNumberAndNumber) {
                   minimumDifferenceHiddenNumberAndNumber = differenceHiddenNumberAndNumber;
                   Arrays.fill(winners, 0, winners.length, null);
                   winners[0] = player;
               } else if (minimumDifferenceHiddenNumberAndNumber == differenceHiddenNumberAndNumber) {
                  for (int i = 0; i < winners.length; i++) {
                      if (player.equals(winners[i])) {
                         break;
                      }
                      if (winners[i] == null) {
                         winners[i] = player;
                         break;
                      }
                  }
               }
           }
        }
        for (Player playerWinner : winners) {
            if (playerWinner != null) {
                for (Player player : players) {
                    if (playerWinner.equals(player)) {
                        player.incNumberWins();
                    }
                }
            }
        }
    }

    private boolean checkEndAttemptsInRound() {
        return players[players.length - 1].getAttempt() != NUMBER_ATTEMPTS;
    }

    private void printRoundWins(int round) {
        Player[] winners = new Player[players.length];
        System.out.println("Результат по " + round + " раунду");
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
            for (int number : player.getNumbers()) {
                    System.out.print(" " + number);
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


