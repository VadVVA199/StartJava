package com.startjava.lesson_1.base;

public class IfElseStatementTheme {
    
    public static void main(String[] args) {
        System.out.println("\n1 Перевод псевдокода на язык Java");
        int age = 21;
        if (age > 20) {
            System.out.println("\tГражданин Гондураса мужчина либо женщина может вступить в брак");
        } else {
            System.out.println("\tГражданин Гондураса мужчина либо женщина " +
                    "не может вступить в брак");
        } 
        char gender = 'M';
        if (gender != 'M') {
            System.out.println("\tГражданин не может быть призван в ряды вооруженных сил РФ");
        } else {
            System.out.println("\tГражданин может быть призван в ряды вооруженных сил РФ");
        }
        double height = 1.79;
        if (height < 1.80) {
            System.out.println("\tКарьеру фотомодели из-за роста сделать будет трудно");
        } else {
            System.out.println("\tПроблем из-за роста у фотомодели не будет");
        } 
        char firstLetterName = "Mary".charAt(0);
        if (firstLetterName == 'M') {
            System.out.println("\tЕсть бланки с буквой M для оформления Тарологом");
        } else if (firstLetterName == 'I') {
            System.out.println("\tЕсть бланки с буквой I для оформления Тарологом");
        } else {
            System.out.println("\tЗаказать бланк для буквы " + firstLetterName);
        }

        System.out.println("\n2 Поиск max и min числа");
        int max = 148;
        int min = 25;
        System.out.println("\tчисло max = " + max + ", число min = " + min);
        if (max < min) {
            System.out.println("\tчисло max меньше числа min");
        } else if (max > min) {
            System.out.println("\tчисло max больше числа min");
        } else {
            System.out.println("\tчисло max равно числу min");
        }

        System.out.println("\n3 Работа с числом");
        int srcNum = -5;
        System.out.println("\tисходное число: " + srcNum);
        if(srcNum != 0) {
            if (srcNum % 2 == 0) {
                System.out.println("\tчисло четное");
            } else {
                System.out.println("\tчисло нечетное");
            }
            if (srcNum > 0) {
                System.out.println("\tчисло положительное");
            } else {
                System.out.println("\tчисло отрицательное");
            } 
        }
        System.out.println("\n4 Поиск одинаковых цифр в числах");
        int srcNum1 = 145;
        int srcNum2 = 125;
        System.out.println("\tпервое число " + srcNum1 + " второе число " + srcNum2);
        int numHundreds1 = srcNum1 / 100;
        int numTens1 = srcNum1 % 100 / 10;
        int numOnes1 = srcNum1 % 10;
        int numHundreds2 = srcNum2 / 100;
        int numTens2 = srcNum2 % 100 / 10;
        int numOnes2 = srcNum2 % 10;
        if (numHundreds1 == numHundreds2) {
            System.out.println("\tодинаковые числа " + numHundreds2 + 
                    ", cотни, числа 3-го разряда");
        }
        if (numTens1 == numTens2) {
            System.out.println("\tодинаковые числа " + numTens2 + 
                    ", десятки, числа 2-го разряда");
        }
        if (numOnes1 == numOnes2) {
            System.out.println("\tодинаковые числа " + numOnes2 + 
                    ", единицы, числа 1-го разряда");
        }

        System.out.println("\n5 Определение буквы, числа или символов по их коду");
        char symbol = '\u0057';
        if ((symbol >= 'a') && (symbol <= 'z')) {
            System.out.println("\tмаленькая буква " + symbol);
        } else if ((symbol >= 'A') && (symbol <= 'Z')) {
            System.out.println("\tбольшая буква " + symbol);
        } else if ((symbol >= '0') && (symbol <= '9')) {
            System.out.println("\tчисло " + symbol);
        } else {
            System.out.println("\tне буква и не число " + symbol);
        }

        System.out.println("\n6 Определения суммы вклада и начисленных банком %");
        double deposit = 300000;
        double pctDeposit = 0;
        if (deposit < 100000) {
            pctDeposit = deposit * 5 / 100;
        } else if (deposit <= 300000) {
            pctDeposit = deposit * 7 / 100;
        } else {
            pctDeposit = deposit * 10 / 100;
        } 
        System.out.println("\tсумма вклада: " + deposit);
        System.out.println("\tначисленный % " + pctDeposit);
        System.out.println("\tитоговая сумма с % " + (deposit += pctDeposit));

        System.out.println("\n7 Определение оценки по предметам");
        int pctHistory = 59;
        int pctProgramming = 91;
        int markProgramming = 0;
        if (pctProgramming > 91) { 
            markProgramming = 5;
        } else if (pctProgramming > 73) {
            markProgramming = 4;
        } else if (pctProgramming > 60) {
            markProgramming = 3;
        } else {
            markProgramming = 2;
        }
        int markHistory = 0;
        if (pctHistory > 91) { 
            markHistory = 5;
        } else if (pctHistory > 73) {
            markHistory = 4;
        } else if (pctHistory > 60) {
            markHistory = 3;
        } else {
            markHistory = 2;
        }
        System.out.println("\tоценка " + markHistory + " - история");
        System.out.println("\tоценка " + markProgramming + " - программирование");
        int avgGradeMark = (markHistory + markProgramming) / 2;
        double avgGradeSubject = (pctProgramming + pctHistory) / 2;
        System.out.println("\tсредний бал оценок по предметам " + avgGradeMark);
        System.out.println("\tсредний % по предметам " + avgGradeSubject);

        System.out.println("\n8 Расчет прибыли");
        int rentMonth = 5000;
        int salesMonth = 13000;
        int costMonth = 9000;
        int profitYear = (salesMonth - costMonth - rentMonth) * 12;
        if (profitYear > 0) {
            System.out.println("\tприбыль за год +" + profitYear);
        } else {
            System.out.println("\tприбыль за год " + profitYear);
        }

        System.out.println("\n9 Подсчет количества банкнот");
        int withdrawingCashUsd = 576;
        int quantityHundredDollarBill = 100;
        int quantityTenDollarBill = 5;
        int quantityOneDollarBill = 100;
        int numHundredDollarBill = withdrawingCashUsd / 100;
        int numTenDollarBill = withdrawingCashUsd % 100 / 10;
        int numOneDollarBill = withdrawingCashUsd % 10;
        System.out.println("\tноминалы банкнот :\n\t\t 100$ - " + quantityHundredDollarBill + 
                "\n\t\t 10$ - " + quantityTenDollarBill +"\n\t\t 1$ - " + quantityOneDollarBill);
        System.out.println("\tтребуемое кол-во банкнот на сумму: " + withdrawingCashUsd + 
                "\n\t\t 100$ - " + numHundredDollarBill + "\n\t\t 10$ - " + numTenDollarBill + 
                "\n\t\t 1$ - " + numOneDollarBill);
        if (quantityHundredDollarBill < numHundredDollarBill) {
            numTenDollarBill += (numHundredDollarBill - quantityHundredDollarBill) * 10;
            numHundredDollarBill = quantityHundredDollarBill;
        }
        if (quantityTenDollarBill < numTenDollarBill) {
            numOneDollarBill += (numTenDollarBill - quantityTenDollarBill) * 10;
            numTenDollarBill = quantityTenDollarBill;
        }
        if (quantityOneDollarBill < numOneDollarBill) {
            System.out.println("\tпоменяйте сумму т.к. на эту сумму нет купюр");
        } else {
            System.out.println("\tколичество банкнот к выдачи: \n\t\t 100$ - " + 
                    numHundredDollarBill + "\n\t\t 10$ - " + numTenDollarBill + "\n\t\t 1$ - " + 
                    numOneDollarBill);
        }
    }
}