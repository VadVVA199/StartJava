package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        char option = 'y';
        Scanner scanner = new Scanner(System.in);
        while (option == 'y') {
            System.out.print("Введите математическое выражение: ");
            try {
                System.out.println("Результат: " + Calculator.calculate(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Вы ввели некорректные данные!");
            }
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                option = scanner.nextLine().charAt(0);
            } while (option != 'y' && option != 'n');
        }
    }
}