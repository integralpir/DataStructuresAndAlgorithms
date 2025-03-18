package second_semester.lesson5.examples;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        UnorderedArray array = new UnorderedArray(10);

        for (int i = 0; i < array.maxSize(); i++) {
            array.insert(Math.abs(RANDOM.nextLong(1, 100)));
        }

        array.display();
        array.sort();
        array.display();

        OrderedArray orderedArray1 = new OrderedArray(4);
        OrderedArray orderedArray2 = new OrderedArray(6);

        orderedArray1.insert(23);
        orderedArray1.insert(47);
        orderedArray1.insert(81);
        orderedArray1.insert(95);

        orderedArray2.insert(7);
        orderedArray2.insert(14);
        orderedArray2.insert(39);
        orderedArray2.insert(55);
        orderedArray2.insert(62);
        orderedArray2.insert(74);

        orderedArray1.display();
        orderedArray2.display();
        System.out.println(Arrays.toString(Collections.orderedMerge(orderedArray1, orderedArray2)));
    }
}
