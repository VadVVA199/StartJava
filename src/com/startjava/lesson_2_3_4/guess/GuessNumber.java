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
                        break;
                    }
                    checkEndAttempts(player);
                }
                outRoundAttempts = checkEndAttemptsInRound(isWinner);
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

    private void checkEndAttempts(Player player) {
        if (player.getAttempt() >= NUMBER_ATTEMPTS) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
    }

    private boolean checkEndAttemptsInRound(boolean isWinner) {
        if (isWinner) {
            return false;
        }
        return players[players.length - 1].getAttempt() != NUMBER_ATTEMPTS;
    }

    private void printRoundWinsTotal() {
        System.out.println("Результат по " + NUMBER_ROUNDS + " раундам игры");
        int numberWinners = 0;
        for (Player player : players) {
            if (player.getNumberWins() != 0) {
                numberWinners++;
            }
        }
        if (numberWinners == 0) {
            System.out.println("Победителей в игре нет");
            return;
        }
        Player[] winners = new Player[numberWinners];
        int index = 0;
        for (Player player : players) {
            if (player.getNumberWins() != 0) {
                winners[index] = player;
                index++;
            }
        }
        for (int i = 0; i < winners.length; i++) {
            for (int j = 0; j < winners.length - 1; j++) {
                if (winners[j].getNumberWins() < winners[j + 1].getNumberWins()) {
                    Player temp = winners[j];
                    winners[j] = winners[j + 1];
                    winners[j + 1] = temp;
                }
            }
        }
        index = 0;
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
        System.out.println();
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
}


