package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private static int num1;
    private static int num2;
    private static char sing;

    public static int calculate(String expression) throws Exception {
        parseExpression(expression.split(" "));
        return switch (sing) {
            case '+':
                yield Math.addExact(num1, num2);
            case '-':
                yield Math.subtractExact(num1, num2);
            case '/':
                yield num1 / num2;
            case '*':
                yield  Math.multiplyExact(num1, num2);
            case '%':
                yield num1 % num2;
            case '^':
                int counter = num2;
                int resultNumberPower = 1;
                while (counter > 0) {
                    resultNumberPower *= num1;
                    counter--;
                }
                yield resultNumberPower;
            default:
                throw new Exception();
        };
    }

    private static void parseExpression(String[] expression) throws Exception {
        if (Integer.parseInt(expression[0]) < 0 || Integer.parseInt(expression[2]) < 0) {
            throw new Exception();
        } else {
            num1 = Integer.parseInt(expression[0]);
            sing = expression[1].charAt(0);
            num2 = Integer.parseInt(expression[2]);
        }
    }
}