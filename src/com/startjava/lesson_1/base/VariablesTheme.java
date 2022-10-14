package com.startjava.lesson_1.base;

public class VariablesTheme {
    
    public static void main(String[] args) {
        System.out.println("1. Создание переменных и вывод их значений на консоль.");
        byte cpu = 2;
        short verOs = 10;
        int installedMemoryRam = 8;
        long hdd = 932l;
        float maxSpeed = 3.5f;
        char sockets = '1';
        boolean penAndTouch = false;
        System.out.println("\tКоличество ядер процессора: " + cpu);
        System.out.println("\tВерсия Windows: " + verOs);
        System.out.println("\tОбъем оперативной памяти в ГГб: " + installedMemoryRam);
        System.out.println("\tОбъем памяти на жестком диске ГГб: " + hdd);
        System.out.println("\tЧастота процессора в ГГц: " + maxSpeed);
        System.out.println("\tКоличество сокетов: " + sockets);
        System.out.println("\tДоступны ли для экрана перо и сенсорный ввод: " + penAndTouch);

        System.out.println("\n2. Расчет стоимости товара со скидкой.");
        int penPrice = 100;
        int bookPrice = 200;
        int discont = 11;
        int totalPrice = penPrice + bookPrice;
        int discountPrice = (totalPrice * discont) / 100;
        System.out.println("\tСумма скидки: " + discont + " %");
        System.out.println("\tОбщая стоимость товара со скидкой: " +
                discountPrice + " руб.");

        System.out.println("\n3. Вывод на консоль слова JAVA.");
        System.out.println("\t   J    a  v     v  a    ");
        System.out.println("\t   J   a a  v   v  a a   ");
        System.out.println("\tJ  J  aaaaa  V V  aaaaa  ");
        System.out.println("\t JJ  a     a  V  a     a ");

        System.out.println("\n4. Отображение min и max значений числовых данных.");
        byte byteMax = 127;
        short shortMax = 32767;
        int intMax = 2147483647;
        long longMax = 9223372036854775807l;
        System.out.println("\tПервоначальное значение числа типа byte: " + byteMax);
        System.out.println("\tПервоначальное значение числа типа short: " + shortMax);
        System.out.println("\tПервоначальное значение числа типа int: " + intMax);
        System.out.println("\tПервоначальное значение числа типа long: " + longMax);
        System.out.println("\tЗначение после инкремента числа типа byte: " + (++byteMax));
        System.out.println("\tЗначение после инкремента числа типа short: " + (++shortMax));
        System.out.println("\tЗначение после инкремента числа типа int: " + (++intMax));
        System.out.println("\tЗначение после инкремента числа типа long: " + (++longMax));
        System.out.println("\tЗначение после декремента числа типа byte: " + (--byteMax));
        System.out.println("\tЗначение после декремента числа типа short: " + (--shortMax));
        System.out.println("\tЗначение после декремента числа типа int: " + (--intMax));
        System.out.println("\tЗначение после декремента числа типа long: " + (--longMax));

        System.out.println("\n5. Перестановка значений переменных.");
        int num1 = 2;
        int num2 = 5;
        System.out.println("\tПерестановка значений переменных с помощью третьей переменной");
        System.out.println("\t\tИсходные значения переменных: \n\t\t\tnum1: " + num1 + 
                "\n\t\t\tnum2: " + num2);
        int num3 = num1;
        num1 = num2;
        num2 = num3; 
        System.out.println("\t\tНовые значения переменных: \n\t\t\tnum1: " + num1 + 
                "\n\t\t\tnum2: " + num2);
        System.out.println("\tПерестановка значений переменных с помощью арифметических операций");
        System.out.println("\t\tИсходные значения переменных: \n\t\t\tnum1: " + num1 + 
                "\n\t\t\tnum2: " + num2);
        num1 += num2;
        num2 = num1 - num2;
        num1 -= num2; 
        System.out.println("\t\tНовые значения переменных: \n\t\t\tnum1: " + num1 + 
                "\n\t\t\tnum2: " + num2);
        System.out.println("\tПерестановка значений переменных с помощью побитовой операции ^");
        System.out.println("\t\tИсходные значения переменных: \n\t\t\tnum1: " + num1 + 
                "\n\t\t\tnum2: " + num2);
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2; 
        System.out.println("\t\tНовые значения переменных: \n\t\t\tnum1: " + num1 + 
                "\n\t\t\tnum2: " + num2);

        System.out.println("\n6. Вывод символов и их кодов.");
        char char35 = '#';
        char char38 = '&';
        char char64 = '@';
        char char94 = '^';
        char char95 = '_';
        System.out.println("\t код: " + (int) char35 + " символ: " + char35);
        System.out.println("\t код: " + (int) char38 + " символ: " + char38);
        System.out.println("\t код: " + (int) char64 + " символ: " + char64);
        System.out.println("\t код: " + (int) char94 + " символ: " + char94);
        System.out.println("\t код: " + (int) char95 + " символ: " + char95);

        System.out.println("\n7. Отображения сотен, десятков и единиц числа.");
        int srcNum = 123;
        int numHundreds = srcNum / 100;
        int numTens = srcNum % 100 / 10;
        int numOnes = srcNum % 10;
        System.out.println("\tЧисло " + srcNum + " содержит: \n\t\t" + numHundreds + 
                " сотен\n\t\t" + numTens + " десятков\n\t\t" + numOnes + " единиц" );

        System.out.println("\n8. Вывод на консоль ASCII-арт Дюка.");
        char slash = 47;
        char backslash = 92;
        char underline = 95;
        char leftRoundBracket = 40;
        char rightRoundBracket = 41;
        System.out.println("\t    " + slash + backslash + "    ");
        System.out.println("\t   " + slash + "  " + backslash + "   ");
        System.out.println("\t  " + slash + underline + leftRoundBracket + " " + 
                rightRoundBracket + backslash + "  ");
        System.out.println("\t " + slash + "      " + backslash + " ");
        System.out.println("\t"+ slash + underline + underline + underline + underline + slash +
                backslash + underline + underline + backslash);

        System.out.println("\n9. Произведение и сумма цифр числа.");
        srcNum = 345;
        numHundreds = srcNum / 100;
        numTens = srcNum % 100 / 10;
        numOnes = srcNum % 10;
        int sumDigits = numHundreds + numTens + numOnes;
        int prodDigits = numHundreds * numTens * numOnes;
        System.out.println("\tсумма цифр числа " + srcNum + " = " + sumDigits);
        System.out.println("\tпроизведение цифр числа " + srcNum + " = " + prodDigits);

        System.out.println("\n10. Преобразование секунд.");
        int numberOfSeconds = 86399;
        int hh = numberOfSeconds / 3600; 
        int mm = numberOfSeconds % 3600 / 60;
        int ss = numberOfSeconds % 60;
        System.out.println("\tколичество секунд: " + numberOfSeconds + ", переведено в формат: " + 
                hh + ":" + mm + ":" + ss);
    }    
}