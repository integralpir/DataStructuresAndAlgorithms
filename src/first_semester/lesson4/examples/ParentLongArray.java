package first_semester.lesson4.examples;

public abstract class ParentLongArray implements ArrayInterface {
    protected final long[] array;
    protected int nElems;

    public ParentLongArray(int size) {
        this.array = new long[size];
        this.nElems = 0;
    }

    @Override
    public boolean insert(long value) {
        for (int i = 0; i < nElems; i++) {
            if (array[i] == value) {
                return false;
            }
        }

        array[nElems] = value;
        nElems++;
        return true;
    }

    @Override
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

    @Override
    public long getMax() {
        long maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < nElems; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        return maxValue;
    }

    @Override
    public long getMin() {
        long minValue = Integer.MAX_VALUE;

        for (int i = 0; i < nElems; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }

        return minValue;
    }

    @Override
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int getSize() {
        return this.nElems;
    }
}
