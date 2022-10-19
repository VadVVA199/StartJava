package com.startjava.lesson_2_3_4.array;

public class ArrayTheme {

    public static void main(String[] args) {
        System.out.println("1. Реверс значений массива");
        int[] intArr =  {25,35,10,5,88,91};
        ArrayTheme.printArrayInt(intArr);
        int len = intArr.length;
        for (int i = 0; i < len / 2; i++) {
            int tmp = intArr[i];
            intArr[i] = intArr[len - i - 1];
            intArr[len - i - 1] = tmp;
        }
        System.out.println();
        ArrayTheme.printArrayInt(intArr);

        System.out.println("\n\n2. Вывод произведения элементов массива");
        int[] arrayInt = new int[10];
        len = arrayInt.length;
        for (int i = 0; i < len; i++) {
            arrayInt[i] =  (int) (Math.random() * 9) + 1;
        }
        int product = 1;
        String exception = "";
        for (int i = 0; i < len; i++) {
            product *= i != 0 && i != 9 ? arrayInt[i] : 1;
            exception += i == 0 || i == 9 ? " Индекс: " + i + " Значение: " + arrayInt[i] + "; ": "";
            System.out.print(i != 0 && i != 9 ? arrayInt[i] : "");
            System.out.print(i != 0 && i != 8 && i != 9 ? " * " : "");
            System.out.print(i == 9 ? " = " + product : "");
        }
        System.out.println();
        System.out.println(exception);

        System.out.println("\n3. Удаление элементов массива");
        double[] arrayDouble = new double[15];
        len = arrayDouble.length;
        for (int i = 0; i < len; i++) {
            double num = Math.random();
            arrayDouble[i] = num;
        }
        double numberMiddle = arrayDouble[len / 2];
        ArrayTheme.printArrayDouble(arrayDouble);
        for (int i = 0; i < len; i++) {
            arrayDouble[i] = 0 < arrayDouble[i] ? Math.random(): 0.0;
        }
        System.out.println();
        ArrayTheme.printArrayDouble(arrayDouble);
        System.out.println();

        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке");
        char[] symbols = new char[26];
        char liter = 'A';
        for (int i = 0; i < 26; i++) {
            symbols[i] = liter;
            liter++;
        }
        int numRows = 26;
        for (int i = 25; 0 <= i; i--) {
            int cycles = numRows - i;
            int numColumns = numRows;
            while (cycles > 0) {
                System.out.print(symbols[--numColumns]);
                cycles--;
            }
            System.out.println();
        }

        System.out.println("\n5. Генерация уникальных чисел");
        int[] intArray = new int[30];
        len = intArray.length;
        for (int i = 0; i < len; i++) {
            intArray[i] = (int) (60 + Math.random() * 40);
            for (int j = 0; j < i; j++) {
                if (intArray[i] == intArray[j]) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (intArray[i] > intArray[j]) {
                    int temp = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
        int numberElement = 1;
        for (int number : intArray) {
            if (numberElement % 10 == 0) {
                System.out.println(number + " ");
                numberElement++;
            } else {
                System.out.print(number + " ");
                numberElement++;
            }
        }

        System.out.println("\n6. Сдвиг элементов массива");
        String[] arrStr = {" ","AA","","BBB","CC","D"," ","E","FF","G",""};
        ArrayTheme.printArrayString(arrStr);
        System.out.println();
        int lenNewArray = 0;
        for (String string : arrStr) {
            if(!string.isBlank()) {
                lenNewArray++;
            }
        }
        String[] arrStrCopy = new String[lenNewArray];
        int startIndex = -1;
        int endIndex = -1;
        int startIndexCopy = 0;
        for (int i = 0; i < lenNewArray; i++) {
            if (!(arrStr[i].isBlank() || startIndex > 0)) {
                startIndex = i;
            } else if (arrStr[i].isBlank()) {
                endIndex = i;
            }
            if (startIndex >= 0 && endIndex > 0) {
                System.arraycopy(arrStr, startIndex,arrStrCopy,startIndexCopy,endIndex - startIndex);
                startIndexCopy = startIndexCopy + (endIndex - startIndex);
                startIndex = -1;
                endIndex = -1;
            }
        }
        ArrayTheme.printArrayString(arrStrCopy);
    }

    private static void printArrayInt(int[] intArr) {
        for (int number: intArr) {
            System.out.print(number + " ");
        }
    }

    private static void printArrayDouble(double[] arrayDouble) {
        int i = 0;
        for (double number : arrayDouble) {
            if (i == 8) {
                System.out.printf("%n %.3f ", number);
            } else {
                System.out.printf(" %.3f ", number);
            }
            i++;
        }
    }

    private static void printArrayString(String[] arrayString) {
        for (String str : arrayString) {
            System.out.print(str + " ");
        }
    }
}
