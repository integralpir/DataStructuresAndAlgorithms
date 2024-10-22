package lesson3.array_examples.good_practice;

import java.util.Random;

public class HighInterfaceClient {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 100;
        HighInterfaceArray array = new HighInterfaceArrayImpl(size);

        for (int i = 0; i < size; i++) { // заполнение массива
            array.insert(random.nextLong(50));
        }

        array.display();

        long searchValue = random.nextLong(50);
        if (array.find(searchValue)) {
            System.out.println("Значение было найдено. " + searchValue);
        } else {
            System.out.println("Не удалось найти значение. " + searchValue);
        }
    }
}
