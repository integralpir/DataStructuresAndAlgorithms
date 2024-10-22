package lesson3.array_examples.without_interface;

import java.util.Random;

public class ArrayExample {
    public static void main(String[] args) {
        String separator = "__________________________________________________________";
        System.out.println(separator);
        System.out.println("Инициализация массива");
        Random random = new Random();
        long[] arr; // ссылка на массив

        arr = new long[100]; // инициализация массива
        int nElements = 100;

        for (int i = 0; i < arr.length; i++) { // заполнение массива
            arr[i] = random.nextLong(200);
        }
        System.out.println(separator);
        System.out.println("Операция вывода элементов массива.");

        for (long element : arr) { // вывод элементов массива
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println(separator);
        System.out.println("Операция поиска.");

        // выбираем случайный элемент
        int arrayElmIndex = random.nextInt(nElements);
        long elm = arr[arrayElmIndex];
        System.out.println("Будем искать элемент под этим индексом: " + arrayElmIndex + ", с таким значением: " + elm + ".");

        for (int i = 0; i < nElements; i++) { // операция поиска
            if (arr[i] == elm) {
                System.out.println("Элемент найден под индексом: " + i + ".");
                break;
            }

            if (i == nElements - 1) {
                System.out.println("Не удалось найти искомый элемент...");
            } else {
                System.out.println("Элемент под индексом: " + i + " не является искомым элементом.");
            }
        }

        System.out.println(separator);
        System.out.println("Операция удаления.");

        // выбираем случайный элемент
        arrayElmIndex = random.nextInt(nElements);
        elm = arr[arrayElmIndex];
        System.out.println("Будем удалять элемент под этим индексом: " + arrayElmIndex + ", с таким значением: " + elm + ".");
        int deleteIndex = -1;

        // операция удаления
        for (int i = 0; i < nElements; i++) {
            if (arr[i] == elm) {
                deleteIndex = i;
                System.out.println("Элемент найден под индексом: " + i + ".");
                break;
            }
        }

        //сдвигаем элементы
        for (int j = deleteIndex; j < nElements - 1; j++) {
            arr[j] = arr[j + 1];
        }

        //уменьшаем количество элементов
        nElements--;

        for (int i = 0; i < nElements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(separator);
    }
}
