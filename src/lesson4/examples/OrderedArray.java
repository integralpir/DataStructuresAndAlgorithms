package lesson4.examples;

public class OrderedArray extends ParentLongArray {
    public OrderedArray(int size) {
        super(size);
    }

    @Override
    public boolean contains(long searchValue) {
        int operationsNumber = 0;
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int currentIndex;

        while (true) {
            System.out.println("Количество операций в упорядоченном массиве: " + ++operationsNumber);
            currentIndex = (lowerBound + upperBound) / 2;
            long currentElement = array[currentIndex];
            if (currentElement == searchValue) {
                return true;
            } else if (lowerBound > upperBound) {
                return false;
            } else {
                if (currentElement < searchValue) {
                    lowerBound = currentIndex + 1;
                } else {
                    upperBound = currentIndex - 1;
                }
            }
        }
    }

    @Override
    public boolean insert(long value) {
        if (this.contains(value)) {
            return false;
        }

        int i;
        for (i = 0; i < nElems; i++) {
            if (array[i] > value) {
                break;
            }
        }

        for (int j = nElems; j > i; j--) {
            array[j] = array[j - 1];
        }

        array[i] = value;
        nElems++;
        return true;
    }
}
