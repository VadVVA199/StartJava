package com.startjava.lesson_1.final_;

public class MyFirstGame {
    
    public static void main(String[] args) {
        System.out.println("\tИгра \"Угадай число\"");
        int hiddenNumber = 73;
        int attemp = 1;
        int lowNumber = 1;
        int highNumber = 100;
        while (lowNumber != highNumber) {
            int midlNumber = (lowNumber + highNumber) / 2; 
            System.out.println("\t" + attemp + "-я попытка, число пользователя: " + midlNumber);
            if (hiddenNumber < midlNumber) {
                System.out.println("\tчисло пользователя меньше задуманного числа");
                highNumber = midlNumber - 1;
            } else if (hiddenNumber > midlNumber) {
                System.out.println("\tчисло пользователя больше задуманного числа");
                lowNumber = midlNumber + 1;
            } else {
                if(midlNumber > 0) {
                    System.out.println("\tВы победили задуманное число: " + midlNumber);
                    lowNumber = highNumber;
                } else {
                    System.out.println("\tЗадуманное число не находится в диапазоне!");
                    lowNumber = highNumber;
                }
            } 
            attemp++;
        }
    }
}
