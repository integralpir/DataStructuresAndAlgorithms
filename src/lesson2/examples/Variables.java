package lesson2.examples;

/*
* На Java все пишут camelCase'ом
* */

import java.util.Scanner;

public class Variables {
    public static void main(String[] args) {
        // Шаблон инициализации примитива:
        // <тип переменной> <название переменной> = <значение>

        //целочисленные
        byte byteVar = 1;
        short shortVar = 2;
        int intVar = 3;
        long longVar = 4L;

        //вещественные
        float floatVar = 1.0f;
        double doubleVar = 2.0d;

        //логическая
        boolean booleanVar = true;

        //символьная
        char charVar1 = 12;
        char charVar2 = 'a';
        char charVar3 = '\u0000';

        // Шаблон инициализации объекта:
        // <тип переменной> <название переменной> = new <тип переменной>(<параметры конструктора>);
        // Строка особенный объект и может инициализироваться как примитив, на этапе компиляции все необходимые элементы шаблона подставятся автоматически.
        String string = "Строка";

        // Очень важный на первое время объект
        // Переменная типа Scanner позволяет вводить значения из консоли
        Scanner scanner = new Scanner(System.in);
    }
}
