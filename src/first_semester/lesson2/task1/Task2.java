package first_semester.lesson2.task1;

//Ссылка на задачу - https://acmp.ru/index.asp?main=task&id_task=25&ins=1#solution

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        if (A > B) {
            System.out.println(">");
        } else if (B > A) {
            System.out.println("<");
        } else {
            System.out.println("=");
        }
    }
}
