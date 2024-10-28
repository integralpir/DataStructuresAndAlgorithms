package lesson4.examples;

public class CommonArray extends ParentLongArray {
    public CommonArray(int size) {
        super(size);
    }

    @Override
    public boolean contains(long searchValue) {
        int operationsNumber = 0;

        for (int i = 0; i < nElems; i++) {
            System.out.println("Количество операций в неупорядоченном массиве: " + ++operationsNumber);
            if (array[i] == searchValue) {
                return true;
            }
        }

        return false;
    }
}
