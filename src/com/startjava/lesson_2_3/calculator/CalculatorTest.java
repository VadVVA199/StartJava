package com.startjava.lesson_2_3.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        char option = 'y';
        while (option == 'y') {
            Scanner scanner = new Scanner(System.in);
            Calculator calculator = new Calculator();
            System.out.print("Введите первое число: ");
            calculator.setNum1(scanner.nextInt()); 
            System.out.print("Введите знак математической операции: ");
            calculator.setSing(scanner.next().charAt(0));
            System.out.print("Введите второе число: ");
            calculator.setNum2(scanner.nextInt()); 
            System.out.println("Результат: " + calculator.calculate());
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                option = scanner.next().charAt(0);
            } while (option != 'y' && option != 'n');
        }
    }
}