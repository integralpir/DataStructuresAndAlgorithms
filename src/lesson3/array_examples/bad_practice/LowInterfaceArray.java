package lesson3.array_examples.bad_practice;

public class LowInterfaceArray {
    private long[] array;

    public LowInterfaceArray(int size) {
        this.array = new long[size];
    }

    public void selElement(int index, long value) {
        array[index] = value;
    }

    public long getElement(int index) {
        return array[index];
    }

    public int getArraySize() {
        return array.length;
    }
}

