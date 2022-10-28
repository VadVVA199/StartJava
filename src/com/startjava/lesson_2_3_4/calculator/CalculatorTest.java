package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        char option = 'y';
        Calculator calculator = new Calculator();
        while (option == 'y') {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите математическое выражение: ");
            System.out.println("Результат: " + calculator.calculate(scanner.nextLine()));
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                option = scanner.next().charAt(0);
            } while (option != 'y' && option != 'n');
        }
    }
}