package second_semester.lesson2.examples;

public class OrderedArray {
    private final long[] array;
    private int nElems;

    public OrderedArray(int size) {
        this.array = new long[size];
        this.nElems = 0;
    }

    public boolean contains(long searchValue) {
        return recursionBinarySearch(searchValue, 0, nElems - 1);
    }

    private boolean recursionBinarySearch(long searchKey, int lowerBound, int upperBound) {
        int currentIndex = (lowerBound + upperBound) / 2;

        if (array[currentIndex] == searchKey) {
            return true;
        } else if (lowerBound > upperBound) {
            return false;
        } else {
            if (array[currentIndex] < searchKey) {
                return recursionBinarySearch(searchKey, currentIndex + 1, upperBound);
            } else {
                return recursionBinarySearch(searchKey, lowerBound, currentIndex - 1);
            }
        }
    }

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
