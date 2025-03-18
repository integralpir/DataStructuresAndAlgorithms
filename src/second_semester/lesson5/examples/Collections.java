package second_semester.lesson5.examples;



public class Collections {
    public static long[] orderedMerge(OrderedArray array1, OrderedArray array2) {
        long[] result = new long[array1.actualSize() + array2.actualSize()];

        int array1Index = 0;
        int array2Index = 0;
        int resultArrayIndex = 0;

        while (array1Index < array1.actualSize() && array2Index < array2.actualSize()) {
            if (array1.get(array1Index) < array2.get(array2Index)) {
                result[resultArrayIndex++] = array1.get(array1Index++);
            } else {
                result[resultArrayIndex++] = array2.get(array2Index++);
            }
        }

        while (array1Index < array1.actualSize()) {
            result[resultArrayIndex++] = array1.get(array1Index++);
        }

        while (array2Index < array2.actualSize()) {
            result[resultArrayIndex++] = array2.get(array2Index++);
        }

        return result;
    }
}
