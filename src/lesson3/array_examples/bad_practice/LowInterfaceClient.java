package lesson3.array_examples.bad_practice;

import java.util.Random;

public class LowInterfaceClient {
    public static void main(String[] args) {
        String separator = "__________________________________________________________";
        System.out.println(separator);
        System.out.println("Инициализация массива");
        Random random = new Random();
        LowInterfaceArray lowInterfaceArray; // ссылка на массив
        int nElements;

        lowInterfaceArray = new LowInterfaceArray(100); // инициализация массива

        for (int i = 0; i < lowInterfaceArray.getArraySize(); i++) { // заполнение массива
            lowInterfaceArray.selElement(i, random.nextLong(50));
        }

        nElements = 100;


        System.out.println(separator);
        System.out.println("Операция вывода элементов массива.");

        for (int i = 0; i < nElements; i++) { // вывод элементов массива
            System.out.print(lowInterfaceArray.getElement(i) + " ");
        }
        System.out.println();
        System.out.println(separator);
        System.out.println("Операция поиска.");

        // выбираем случайный элемент
        int arrayElmIndex = random.nextInt(nElements);
        long elm = lowInterfaceArray.getElement(arrayElmIndex);
        System.out.println("Будем искать элемент под этим индексом: " + arrayElmIndex + ", с таким значением: " + elm + ".");

        for (int i = 0; i < nElements; i++) { // операция поиска
            if (lowInterfaceArray.getElement(i) == elm) {
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
        elm = lowInterfaceArray.getElement(arrayElmIndex);
        System.out.println("Будем удалять элемент под этим индексом: " + arrayElmIndex + ", с таким значением: " + elm + ".");
        int deleteIndex = -1;

        // операция удаления
        for (int i = 0; i < nElements; i++) {
            if (lowInterfaceArray.getElement(i) == elm) {
                deleteIndex = i;
                System.out.println("Элемент найден под индексом: " + i + ".");
                break;
            }
        }

        //сдвигаем элементы
        for (int j = deleteIndex; j < nElements - 1; j++) {
            lowInterfaceArray.selElement(j, lowInterfaceArray.getElement(j + 1));
        }

        //уменьшаем количество элементов
        nElements--;

        for (int i = 0; i < nElements; i++) {
            System.out.print(lowInterfaceArray.getElement(i) + " ");
        }
        System.out.println();
        System.out.println(separator);
    }
}
