package com.startjava.lesson_1.base;

public class CyclesTheme {

    public static void main(String[] args) {
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");
        int sumEvenNum = 0;
        int sumOddNum = 0;
        int counter = -10;
        do { 
            if (counter % 2 == 0) {
                sumEvenNum += counter;
            } else {
                sumOddNum += counter;
            }
            counter++;
        } while (counter <= 21);
        System.out.println("\tв промежутке [-10, 21] сумма четных числе = " + sumEvenNum + 
                ", а нечетных = " + sumOddNum);

        System.out.println("\n2. Вывод чисел в интервале (min и max) в порядке убывания");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int min = num1;
        int max = num2;
        if (num1 > max) {
            max = num1;
        }
        if (num3 > max) {
            max = num3;
        }
        if (num2 < min) {
            min = num2;
        }
        if (num3 < min) {
            min = num3;
        }
        System.out.println("\tинтервал в порядке убывания: ");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i == max -1 ? "\t" + i : ", " + i);
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        num1 = 1234;
        System.out.println("\tисходное число - " + num1);
        int reverseNum = 0;
        int sum = 0;
        System.out.print("\tреверсивное число - ");
        while (num1 > 0) {
            int digit = num1 % 10;
            sum += digit;
            System.out.print(digit);
            num1 /= 10;
        }
        System.out.println("\n\tсумма - " + sum);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк");
        int count = 1;
        for (int i = 1; i < 24; i += 2) { 
            System.out.printf("%4s", i); 
            if (count % 5 == 0) {
                System.out.println();
            }   
            count++; 
            }
        for (int i = 0; i <= 5 - count % 5; i++) {
             System.out.printf("%4s", 0);
        }

        System.out.println("\n\n5. Проверка количества единиц на четность");
        num1 = 3141591;
        int copyNum1 = num1;
        int countOnes = 0;
        while (num1 > 0) {
            if (num1 % 10 == 1) {
                countOnes++;
            }
            num1 /= 10;
        }
        if (countOnes != 0) {
            if (countOnes % 2 == 0) {
                System.out.println("\tчисло " + copyNum1 + " содержит " + countOnes + 
                        " четное количество единиц");
            } else {
                System.out.println("\tчисло " + copyNum1 + " содержит " + countOnes + 
                        " нечетное количество единиц");
            }
        } else {
            System.out.println("\tединиц в числе " + copyNum1 + " нет");
        }

        System.out.println("\n6. Отображение фигур в консоли\n");
        for (int numRows = 0; numRows < 5; numRows++) {
                System.out.print("\t");
            for (int numColumns = 0; numColumns < 10; numColumns++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        int numRows = 5;
        int numColumns = 0;
        while (numRows > 0) {
            numColumns = numRows;
            System.out.print("\t");
            while (numColumns > 0) {
                System.out.print("#");
                numColumns--;
            }
            System.out.println();
            numRows--;
        }

        System.out.println();
        int maxNumColumns = 3;
        numRows = 0; 
        counter = 0;
        numColumns = 0; 
        do {
            if (numRows < maxNumColumns) { 
                numColumns = ++counter;
            } else {
                numColumns = --counter; 
            }
            System.out.print("\t");
            do { 
                if (counter != 0) {
                    System.out.print("$");
                }
                numColumns--;
            } while (0 < numColumns);
            numRows++;
            System.out.println();
        } while (0 < counter);

        System.out.println("\n7. Отображение ASCII-символов");
        System.out.printf("\t%7s %7s\n", "Dec", "Char");
        for (int i = 0; i <= 127; i++) {
            char symbol = (char) i;
            if (symbol < '0') {
                if (i % 2 != 0) {
                    System.out.printf("\t%7d %7c\n", i, i);
                }
            } else if (symbol >= 'a' && symbol <= 'z') {
                if (i % 2 == 0) {
                    System.out.printf("\t%7d %7c\n", i, i);
                }
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");
        num1 = 1234321;
        copyNum1 = num1;
        System.out.println("\tисходное число - " + num1);
        reverseNum = 0;
        while (copyNum1 > 0) {
            reverseNum = (reverseNum * 10) + (copyNum1 % 10);
            copyNum1 /= 10;
        }
        if (num1 - reverseNum == 0) {
            System.out.println("\tчисло " + num1 + " является палиндромом");
        } else {
            System.out.println("\tчисло " + num1 + " не является палиндромом");
        }

        System.out.println("\n9. Определение, является ли число счастливым");
        int lukyNumber = 498498;
        int highHalfNumber = lukyNumber / 1000;
        int lowHalfNumber = lukyNumber % 1000;
        int sumLowHalfNumber = 0;
        int sumHighHalfNumber = 0;
        int i = 0;
        while (lukyNumber > 0) {
            int digit = lukyNumber % 10;
            if (i <= 2) {
                sumLowHalfNumber += digit;
            } else {
                sumHighHalfNumber += digit;
            }
            lukyNumber /= 10;
            i++;
        }
        System.out.println("\tсумма цифр справа " + lowHalfNumber + " = " + 
                sumLowHalfNumber);
        System.out.println("\tсумма цифр слева " + highHalfNumber + " = " + 
                sumHighHalfNumber);
        if (sumHighHalfNumber == sumLowHalfNumber) {
            System.out.println("\tчисло является счастливым");
        } else {
            System.out.println("\tчисло не является счастливым");
        }

        System.out.println("\n10. Вывод таблицы умножения Пифагора");
        for (i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j >= 2) {
                    System.out.printf("%4d", (1 * j));
                } else if (i >= 2 && j == 0) {
                    System.out.printf("%4d", (i * 1));
                } else if (i >= 0 && j == 1) {
                    System.out.printf("%4s", '|');
                } else if (i == 1 && j >= 0) {
                    System.out.printf("%4s", '-');
                } else if (i == 0 && j == 0) {
                    System.out.printf("%4s", ' ');
                } else {
                    System.out.printf("%4d", (i * j));
                }
            }
        }
    }
}