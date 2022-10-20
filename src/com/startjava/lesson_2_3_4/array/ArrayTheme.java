package com.startjava.lesson_2_3_4.array;

public class ArrayTheme {

    public static void main(String[] args) {
        System.out.println("1. Реверс значений массива");
        int[] intArr = {25, 35, 10, 5, 88, 91};
        printArrayInt(intArr);
        int len = intArr.length;
        int k = len - 1;
        for (int i = 0; i < len / 2; i++) {
            int tmp = intArr[i];
            intArr[i] = intArr[k];
            intArr[k] = tmp;
            k--;
        }

        System.out.println();
        printArrayInt(intArr);

        System.out.println("\n\n2. Вывод произведения элементов массива");
        int[] intArr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        len = intArr1.length;
        int prodDigit = 1;
        for (int i = 0; i < len; i++) {
            prodDigit *= i != 0 && i != 9 ? intArr1[i] : 1;
            System.out.print(i != 0 && i != 9 ? intArr1[i] : "");
            System.out.print(i != 0 && i != 8 && i != 9 ? " * " : "");
            System.out.print(i == 9 ? " = " + prodDigit : "");
        }
        System.out.println();
        System.out.println("Индекс: " + 0 + " Значение: " + intArr1[0] + "\nИндекс: " + 9 +
                " Значение: " + intArr1[9]);

        System.out.println("\n3. Удаление элементов массива");
        double[] doubleArr = new double[15];
        len = doubleArr.length;
        for (int i = 0; i < len; i++) {
            doubleArr[i] = Math.random();
        }
        double middleNum = doubleArr[len / 2];
        printArrayDouble(doubleArr);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (doubleArr[i] > middleNum ) {
                doubleArr[i] = 0.0;
                sum++;
            }
        }
        System.out.println();
        printArrayDouble(doubleArr);
        System.out.println("\nКоличество обнуленных ячеек: " + sum);

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
        int numElement = 1;
        for (int number : intArray) {
            if (numElement % 10 == 0) {
                System.out.println(number + " ");
                numElement++;
            } else {
                System.out.print(number + " ");
                numElement++;
            }
        }

        System.out.println("\n6. Сдвиг элементов массива");
        String[] strArr = {" ","AA","","BBB","CC","D"," ","E","FF","G",""};
        len = strArr.length;
        printArrayString(strArr);
        System.out.println();
        int lenNewArray = 0;
        for (String string : strArr) {
            if(!string.isBlank()) {
                lenNewArray++;
            }
        }
        String[] arrStrCopy = new String[lenNewArray];
        int startIndex = -1;
        int endIndex = -1;
        int startIndexCopy = 0;
        for (int i = 0; i < len; i++) {
            if (!(strArr[i].isBlank() || startIndex > 0)) {
                startIndex = i;
            }
            if (strArr[i].isBlank() && i != 0 && endIndex < 0) {
                endIndex = i;
            }
            if (startIndex >= 0 && endIndex > 0) {
                System.arraycopy(strArr, startIndex, arrStrCopy, startIndexCopy, endIndex - startIndex);
                startIndexCopy = startIndexCopy + (endIndex - startIndex);
                startIndex = -1;
                endIndex = -1;
            }
        }
        printArrayString(arrStrCopy);
    }

    private static void printArrayInt(int[] intArr) {
        for (int num: intArr) {
            System.out.print(num + " ");
        }
    }

    private static void printArrayDouble(double[] doubleArr) {
        int i = 0;
        for (double num : doubleArr) {
            if (i == 8) {
                System.out.printf("%n %.3f ", num);
            } else {
                System.out.printf(" %.3f ", num);
            }
            i++;
        }
    }

    private static void printArrayString(String[] strArr) {
        for (String str : strArr) {
            System.out.print(str + " ");
        }
    }
}
