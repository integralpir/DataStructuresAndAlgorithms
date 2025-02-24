package second_semester.lesson2.examples;

import java.util.Scanner;

public class RecursionExamples {
    private final static String SEPARATOR = "-----------------------------------------";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = scanner.nextLong();

        triangle(number);
        System.out.println(SEPARATOR);
        factorial(number);
        System.out.println(SEPARATOR);
    }

    private static long triangle(long number) {
        if (number == 1) {
            System.out.println("Возвращаем 1");
            return number;
        } else {
            long temp = number + triangle(number - 1);
            System.out.println("Возвращаем " + temp);
            return temp;
        }
    }

    private static long factorial(long number) {
        if (number == 0) {
            System.out.println("Возвращаем 1");
            return 1;
        } else {
            long temp = number * factorial(number - 1);
            System.out.println("Возвращаем " + temp);
            return temp;
        }
    }
}
