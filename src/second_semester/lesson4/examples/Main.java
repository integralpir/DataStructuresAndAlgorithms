package second_semester.lesson4.examples;

import java.util.Random;

public class Main {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Array array = new UnorderedArray(10);

        for (int i = 0; i < array.maxSize(); i++) {
            array.insert(Math.abs(RANDOM.nextLong(1, 100)));
        }

        array.display();
        long pivot = 50;
        System.out.println("Pivot is " + pivot);
        int partitionIndex = array.partition(pivot);
        System.out.println("Partition index is " + partitionIndex);
        array.display();

        array.sort();
        array.display();
    }
}
