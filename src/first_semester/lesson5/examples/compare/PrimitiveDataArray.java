package first_semester.lesson5.examples.compare;

public class PrimitiveDataArray {
    private final long[] array;
    private int nElems;

    public PrimitiveDataArray(int size) {
        this.array = new long[size];
        this.nElems = 0;
    }

    public boolean contains(long searchValue) {
        for (int i = 0; i < nElems; i++) {
            if (array[i] == searchValue) {
                return true;
            }
        }

        return false;
    }

    public boolean insert(long value) {
        if (this.contains(value)) {
            return false;
        }

        array[nElems] = value;
        nElems++;
        return true;
    }

    public boolean delete(long value) {
        int i;
        for (i = 0; i < this.nElems; i++) {
            if (array[i] == value) {
                break;
            }
        }

        if (i == nElems - 1) {
            return false;
        } else {
            for (int j = i; j < nElems - 1; j++) {
                array[j] = array[j + 1];
            }
            nElems--;
            return true;
        }
    }

    public long getMax() {
        long maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < nElems; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        return maxValue;
    }

    public long getMin() {
        long minValue = Integer.MAX_VALUE;

        for (int i = 0; i < nElems; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }

        return minValue;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return nElems;
    }
}
