package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private static int num1;
    private static int num2;
    private static char sing;

    public static int calculate(String expression) {
        checkString(expression);
        return switch (sing) {
            case '+' -> Math.addExact(num1, num2);
            case '-' -> Math.subtractExact(num1, num2);
            case '/' -> num1 / num2;
            case '*' -> Math.multiplyExact(num1, num2);
            case '%' -> num1 % num2;
            case '^' -> {
                int result = 1;
                for (int counter = num2; counter > 0; counter--) {
                    result *= num1;
                }
                yield result;
            }
            default -> throw new IllegalArgumentException("Ошибка, ввели неверный оператор в выражение");
        };
    }

    private static void checkString(String expression) {
        if (expression.isBlank()) {
            throw new IllegalArgumentException("Ошибка, Ввели пустую строку");
        }
        String[] array = expression.split(" ");
        if (array.length != 3) {
            throw new IllegalArgumentException("Ошибка, Нет пробелов между символами, либо их очень много");
        }
        parseExpression(array);
    }

    private static void parseExpression(String[] expression) {
        if (Integer.parseInt(expression[0]) < 0 || Integer.parseInt(expression[2]) < 0) {
            throw new IllegalArgumentException("Ошибка, ввели отрицательное число");
        }
        num1 = Integer.parseInt(expression[0]);
        sing = expression[1].charAt(0);
        num2 = Integer.parseInt(expression[2]);
    }
}