package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        char option = 'y';
        while (option == 'y') {
            Scanner scanner = new Scanner(System.in);
            Calculator calculator = new Calculator();
            System.out.print("Введите математическое выражение: ");
            calculator.setExpression(scanner.nextLine().split(" "));
            System.out.println("Результат: " + calculator.calculate());
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                option = scanner.next().charAt(0);
            } while (option != 'y' && option != 'n');
        }
    }
}