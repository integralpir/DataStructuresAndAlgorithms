package second_semester.lesson5.examples;

public class UnorderedArray implements Array {
    private final long[] data;
    private int elementsNumber;

    public UnorderedArray(int maxSize) {
        data = new long[maxSize];
        elementsNumber = 0;
    }

    public void sort() {
        long[] tempArray = new long[elementsNumber];
        mergeSort(tempArray, 0, elementsNumber - 1);
    }

    private void mergeSort(long[] tempArray, int lowerBound, int upperBound) {
        if (lowerBound != upperBound) {
            int middle = (lowerBound + upperBound) / 2;
            mergeSort(tempArray, lowerBound, middle);
            mergeSort(tempArray, middle + 1, upperBound);
            merge(tempArray, lowerBound, middle + 1, upperBound);
        }
    }

    private void merge(long[] tempArr, int lowPtr, int highPtr, int upperBound) {
        int tempArrIndex = 0;
        int lowerBound = lowPtr;
        int middle = highPtr - 1;
        int elementsNumber = upperBound - lowerBound + 1;

        while (lowPtr <= middle && highPtr <= upperBound) {
            if (data[lowPtr] < data[highPtr]) {
                tempArr[tempArrIndex++] = data[lowPtr++];
            } else {
                tempArr[tempArrIndex++] = data[highPtr++];
            }
        }

        while (lowPtr <= middle) {
            tempArr[tempArrIndex++] = data[lowPtr++];
        }

        while (highPtr <= upperBound) {
            tempArr[tempArrIndex++] = data[highPtr++];
        }

        for (tempArrIndex = 0; tempArrIndex < elementsNumber; tempArrIndex++) {
            data[lowerBound + tempArrIndex] = tempArr[tempArrIndex];
        }
    }

    @Override
    public long get(int index) {
        return data[index];
    }

    @Override
    public boolean find(long key) {
        for (int i = 0; i < elementsNumber; i++) {
            if (data[i] == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void insert(long value) {
        if (value >= 0) {
            data[elementsNumber++] = value;
        }
    }

    @Override
    public boolean delete(long value) {
        int deletingElementIndex = -1;

        for (int i = 0; i < elementsNumber; i++) {
            if (data[i] == value) {
                deletingElementIndex = i;
            }
        }

        if (deletingElementIndex == -1) {
            return false;
        } else {
            deleteDataByIndex(deletingElementIndex);
            return true;
        }
    }

    private void deleteDataByIndex(int index) {
        for (int j = index; j < elementsNumber - 1; j++) {
            data[j] = data[j + 1];
        }

        elementsNumber--;
    }

    @Override
    public void display() {
        for (int i = 0; i < elementsNumber; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int actualSize() {
        return elementsNumber;
    }

    @Override
    public int maxSize() {
        return data.length;
    }
}
