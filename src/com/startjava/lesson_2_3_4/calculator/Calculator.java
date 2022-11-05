package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private static int num1;
    private static int num2;
    private static char sing;

    public static int calculate(String expression) {
        parseExpression(expression.split(" "));
        return switch (sing) {
            case '+' -> Math.addExact(num1, num2);
            case '-' -> Math.subtractExact(num1, num2);
            case '/' -> num1 / num2;
            case '*' -> Math.multiplyExact(num1, num2);
            case '%' -> num1 % num2;
            case '^' -> {
                int counter = num2;
                int resultNumberPower = 1;
                while (counter > 0) {
                    resultNumberPower *= num1;
                    counter--;
                }
                yield resultNumberPower;
            }
            default -> throw new IllegalArgumentException();
        };
    }

    private static void parseExpression(String[] expression) {
        if (Integer.parseInt(expression[0]) < 0 || Integer.parseInt(expression[2]) < 0) {
            throw new NullPointerException();
        }
            num1 = Integer.parseInt(expression[0]);
            sing = expression[1].charAt(0);
            num2 = Integer.parseInt(expression[2]);
    }
}