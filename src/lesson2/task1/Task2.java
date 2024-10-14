package lesson2.task1;

//Ссылка на задачу - https://acmp.ru/index.asp?main=task&id_task=25&ins=1#solution

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (x > y) {
            System.out.println(">");
        } else if (y > x) {
            System.out.println("<");
        } else {
            System.out.println("=");
        }
    }
}
