package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static final int NUMBER_ATTEMPTS = 10;
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
        Scanner scanner = new Scanner(System.in);
        boolean isWinner = false;
        for (int round = 1; round <= NUMBER_ROUNDS; round++) {
            if ( isWinner || round == 1 ) {
                hiddenNumber = (int) (1 + Math.random() * 100);
                clearPlayerAttempts();
                isWinner = false;
            }
            System.out.println("Начало: " + round + " раунда.");
            boolean outRoundAttempts = true;
            while (outRoundAttempts) {
                for (Player player : players) {
                    enterNumber(player, scanner);
                    if (checkNumber(player, round)) {
                        printPlayerNumbers();
                        isWinner = true;
                    }
                    if (checkEndAttempts(player, isWinner)) {
                        outRoundAttempts = false;
                        break;
                    }
                }
            }
            if (round != NUMBER_ROUNDS) {
                clearPlayerAttempts();
            }
            System.out.println();
        }
        printRoundWinsTotal();
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

    private void printParticipants() {
        System.out.println("\tИгра началась");
        for (int i = 0; i < players.length; i++) {
            System.out.println("\tИмя игрока : " + players[i].getName() + ", игрок номер: " + (i + 1));
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
            player.incNumberWins();
            return true;
        }
        String compareResult = number > hiddenNumber ? " больше " : " меньше ";
        System.out.println("Число: " + number + " игрока: " + name + " " +
                compareResult + " задуманного числа компьютера");
        return false;
    }

    private boolean checkEndAttempts(Player player, boolean isWinner) {
        if (player.getAttempt() >= NUMBER_ATTEMPTS) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
        return  isWinner || players[players.length - 1].getAttempt() == NUMBER_ATTEMPTS;
    }

    private  void printRoundWinsTotal() {
        System.out.println("Результат по " + NUMBER_ROUNDS + " раундам игры");
        Player[] winners = new Player[players.length];
        int maxNumberWins = 0;
        for (Player player : players) {
            if (player.getNumberWins() > maxNumberWins) {
                maxNumberWins = player.getNumberWins();
                winners[0] = player;
            } else if (player.getNumberWins() == maxNumberWins) {
                for (int index = 0; index < winners.length; index++) {
                    if (winners[index] == null || winners[index].getNumberWins() != maxNumberWins) {
                        winners[index] = player;
                        break;
                    }
                }
            }
        }
        for (Player playerWins : winners) {
            if (playerWins != null) {
                System.out.print(playerWins.getName() + " ");
            }
        }
    }

    private void printPlayerNumbers() {
        System.out.println();
        for (Player player : players) {
            System.out.print(player.getName());
            for (int number : player.getNumbers()) {
                System.out.print(" " + number);
            }
            System.out.println();
        }
    }
}


