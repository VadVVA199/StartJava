package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private int num1;
    private int num2;
    private char sing;
    private String[] expression;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setSing(char sing) {
        this.sing = sing;
    }

    public int calculate(String inputLine) {
        expression = inputLine.split(" ");
        parseExpression();
        int result = 1;
        switch (sing) {
            case '+':
                return Math.addExact(num1, num2);
            case '-':
                return Math.subtractExact(num1, num2);
            case '/':
                return num1 / num2;
            case '*':
                return Math.multiplyExact(num1, num2);
            case '%':
                return num1 % num2;
            case '^':
                int counter = num2;
                while (counter > 0) {
                    result *= num1;
                    counter--;
                }
        }
        return result;
    }

    private void parseExpression() {
        this.num1 = Integer.parseInt(expression[0]);
        this.sing = expression[1].charAt(0);
        this.num2 = Integer.parseInt(expression[2]);
    }
}