package com.startjava.lesson_2_3_4.array;

public class ArrayTheme {

    public static void main(String[] args) {
        System.out.println("1. Реверс значений массива");
        int[] intArr = {25, 35, 10, 5, 88, 91};
        printArrInt(intArr);
        int len = intArr.length - 1;
        for (int i = 0; i < len; i++) {
            int tmp = intArr[i];
            intArr[i] = intArr[len];
            intArr[len] = tmp;
            len--;
        }

        System.out.println();
        printArrInt(intArr);

        System.out.println("\n\n2. Вывод произведения элементов массива");
        int[] intArr1 = new int[10];
        for (int i = 0; i < 10; i++) {
            intArr1[i] = i;
        }
        len = intArr1.length - 1;
        int prodDigits = 1;
        for (int i = 1; i < len; i++) {
            prodDigits *= i;
            System.out.print(intArr1[i] + (i != 8 ? " * " : " = " + prodDigits));
        }
        System.out.println("\nИндекс: " + 0 + " Значение: " + intArr1[0] + "\nИндекс: " + 9 +
                " Значение: " + intArr1[9]);

        System.out.println("\n3. Удаление элементов массива");
        double[] doubleArr = new double[15];
        len = doubleArr.length;
        for (int i = 0; i < len; i++) {
            doubleArr[i] = Math.random();
        }
        double middleNum = doubleArr[len / 2];
        printArrDouble(doubleArr);
        int numberZeroCells = 0;
        for (int i = 0; i < len; i++) {
            if (doubleArr[i] > middleNum) {
                doubleArr[i] = 0.0;
                numberZeroCells++;
            }
        }
        System.out.println();
        printArrDouble(doubleArr);
        System.out.println("\nКоличество обнуленных ячеек: " + numberZeroCells);

        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке");
        char[] alphabet = new char[26];
        len = alphabet.length;
        char letter = 'A';
        for (int i = 0; i < len; i++) {
            alphabet[i] = letter;
            letter++;
        }
        int numRows = len;
        for (int i = len - 1; 0 <= i; i--) {
            int numLetterInString = numRows - i;
            int numColumns = numRows;
            for (int j = numLetterInString; j > 0; j--) {
                System.out.print(alphabet[--numColumns]);
            }
            System.out.println();
        }

        System.out.println("\n5. Генерация уникальных чисел");
        int[] intArr2 = new int[30];
        len = intArr2.length;
        for (int i = 0; i < len; i++) {
            int randomNum = (int) (60 + Math.random() * 40);
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (intArr2[j] == randomNum) {
                    unique = false;
                    i--;
                }
            }
            if (unique) {
                intArr2[i] = randomNum;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (intArr2[i] > intArr2[j]) {
                    int temp = intArr2[i];
                    intArr2[i] = intArr2[j];
                    intArr2[j] = temp;
                }
            }
        }
        int numElement = 1;
        for (int number : intArr2) {
            System.out.print(numElement % 10 == 0 ? number + "\n" : number + " ");
            numElement++;
        }

        System.out.println("\n6. Сдвиг элементов массива");
        String[] srcArr = {" ","AA","","BBB","CC","D"," ","E","FF","G",""};
        len = srcArr.length;
        printArrString(srcArr);
        System.out.println();
        int newLen = 0;
        for (String string : srcArr) {
            if(!string.isBlank()) {
                newLen++;
            }
        }
        String[] destArr = new String[newLen];
        int startIndexSrcArr = -1;
        int lenComponentCopiedSrcArr = 0;
        int startIndexDestArr = 0;
        for (int i = 0; i < len; i++) {
            if (!srcArr[i].isBlank()) {
                if (startIndexSrcArr < 0) {
                    startIndexSrcArr = i;
                }
                lenComponentCopiedSrcArr++;
            } else if (lenComponentCopiedSrcArr != 0) {
                System.arraycopy(srcArr, startIndexSrcArr, destArr, startIndexDestArr, lenComponentCopiedSrcArr);
                startIndexDestArr += lenComponentCopiedSrcArr;
                lenComponentCopiedSrcArr = 0;
                startIndexSrcArr = -1;
            }
        }
        printArrString(destArr);
    }

    private static void printArrInt(int[] intArr) {
        for (int num : intArr) {
            System.out.print(num + " ");
        }
    }

    private static void printArrDouble(double[] doubleArr) {
        int i = 0;
        for (double num : doubleArr) {
            System.out.printf(i == 8 ? "%n %.3f " : " %.3f ", num);
            i++;
        }
    }

    private static void printArrString(String[] srcArr) {
        for (String str : srcArr) {
            System.out.print(str + " ");
        }
    }
}
