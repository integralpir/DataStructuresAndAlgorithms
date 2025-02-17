package first_semester.lesson3.array_examples.good_practice;

public class HighInterfaceArrayImpl implements HighInterfaceArray {
    private final long[] array;
    private int nElems;

    public HighInterfaceArrayImpl(int size) {
        this.array = new long[size];
        this.nElems = 0;
    }

    @Override
    public boolean find(long searchValue) {
        for (int i = 0; i < this.nElems; i++) {
            if (array[i] == searchValue) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void insert(long value) {
        array[nElems] = value;
        nElems++;
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
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int getSize() {
        return this.nElems;
    }
}
