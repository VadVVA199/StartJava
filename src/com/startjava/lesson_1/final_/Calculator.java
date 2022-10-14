package com.startjava.lesson_1.final_;

public class Calculator {
    
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 3;
        char sign = '+';
        int result = 0;
        if (sign == '+') {
            result = num1 + num2;
        } else if (sign == '-') {
            result = num1 - num2;
        } else if (sign == '/') {
            result = num1 / num2;
        } else if (sign == '*') {
            result = num1 * num2;
        } else if (sign == '%') {
            result = num1 % num2;
        } else if (sign == '^') {
            result = 1;
            int counter = num2;
            while (counter > 0) {
                result *= num1;
                counter--;
            }
        }
        System.out.println(num1 + " "+ sign +" " + num2 + " = " + result);
    }
}