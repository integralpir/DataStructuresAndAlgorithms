package lesson6.examples.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketsApp {
    public static void main(String[] args) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            String input;
            while (true) {
                System.out.print("Enter string containing delimiters: ");
                System.out.flush();
                input = br.readLine(); // Чтение строки с клавиатуры
                if (input.isEmpty()) { // Завершение, если [Enter]
                    break;
                }

                BracketChecker theChecker = new BracketChecker(input);
                theChecker.check();
            }
        }
    }
}
