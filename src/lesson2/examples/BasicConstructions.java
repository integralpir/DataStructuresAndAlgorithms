package lesson2.examples;

import java.util.Random;
import java.util.Scanner;

public class BasicConstructions {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;

        //1.1 вызов метода
        //simpleMethod(1, 2);

        //arithmetic();
        //compareConstructs();
        //conditionalConstructions();
        //loopConstructions();
    }

    //1. Методы / функции и т.д.
    //Шаблон создания метода
    /*
    * <модификатор доступа (public)> <static (разберем в ООП)> <возвращаемое значение> <название> (<тип аргумента> <локальное название>) {
    *     какой-то код;
    * }
    * */
    public static void simpleMethod(int x, int y) {
        //Код внизу позволяет вывести что-нибудь в консоль
        //Почему именно такая запись, а не просто print() разберем на теме ввода/вывода.
        System.out.println(x);
        System.out.println(y);
    }

    //2. Арифметика
    public static void arithmetic() {
        Random random = new Random();

        int x = random.nextInt(10);
        int y = random.nextInt(10);

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        System.out.println(x + y);
        System.out.println(x - y);
        System.out.println(x * y);
        System.out.println(x / y);
        //Операция получения остатка от деления. Пример: 10 % 3 = 1, 4 % 2 = 0
        //С ее помощью легко определять четность числа
        System.out.println(x % y);

        //Для возведения в степень, тригонометрических операций, и собственно всего, что сложнее вышеописанного.
        //Придется воспользоваться объектом Math.
        //Пример - возводим 3 во 2-ую степень
        System.out.println(Math.pow(3, 2));
    }

    //3. Операции сравнения
    public static void compareConstructs() {
        Random random = new Random();

        int x = random.nextInt();
        int y = random.nextInt();

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        //Base
        System.out.println(x == y);
        System.out.println(x > y);
        System.out.println(x >= y);
        System.out.println(x < y);
        System.out.println(x <= y);

        //Вышеописанные операторы сравнения не подходят для сравнения объектов
        //Сравнение объектов разберем подробнее попозже

        //Есть еще всякие битовые штуки, но это какой-то рокет-сайнс, никогда ими не пользовался
        //Ссылку для заинтересованных приложу
    }

    //4. Условные блоки
    public static void conditionalConstructions() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int x = random.nextInt();
        int y = random.nextInt();
        String status = scanner.next();

        if (x > y) {
            System.out.println("x more than y");
        } else if (x < y) {
            System.out.println("y more than x");
        } else {
            System.out.println("x equals y");
        }

        switch (status) {
            case "NEW" -> {
                System.out.println("operation is new");
            }
            case "PUSH" -> {
                System.out.println("operation in progress");
            }
            case "ERROR" -> {
                System.out.println("operation was rejected");
            }
            default -> {
                System.out.println("unknown status");
            }
        }
    }

    //5. Циклы
    public static void loopConstructions() {
        Scanner scanner = new Scanner(System.in);

        //Инициализация массива
        //<тип данных>[] <название> = new <тип данных>[<размер массива>];
        int[] arr = new int[10];
        //[.][.][.][.][.][.][.][.][.][.]
        int[][] multiplyArr = new int[10][10];
        int[] presetArr = {1, 2, 3, 4, 5, 6};
        //[1][2][3][4][5][6]

        //обычный цикл
        //for (<тип счетчика> <название> = <значение>; <счетчик> <условие> <сравниваемая переменная>; <операция над счетчиком>) {
        //     какой-то код;
        // }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            System.out.println("arr №" + (i + 1) + " = " + arr[i]);
        }

        //for each
        //for (<тип элемента массива> <название переменной, отражающей элемент массива> : <массив>) {
        //     какой-то код;
        // }
        for (int element : arr) {
            System.out.println(element);
        }

        int counter = 0;

        // пока выполняется условие - делай
        // while(<какое-то условие>) {
        //     какой-то код;
        // }
        while (counter < arr.length) {
            counter++;
            System.out.println("counter = " + counter);
        }

        counter = 0;

        // делай - пока выполняется условие
        // do {
        //     какой-то код;
        // } while(<какое-то условие>)
        do {
            counter++;
            System.out.println("counter = " + counter);
        } while (counter < arr.length);
    }
}
