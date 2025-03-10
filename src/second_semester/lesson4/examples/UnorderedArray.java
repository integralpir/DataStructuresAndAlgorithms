package second_semester.lesson4.examples;

public class UnorderedArray implements Array {
    private final long[] data;
    private int elementsNumber;

    public UnorderedArray(int maxSize) {
        data = new long[maxSize];
        elementsNumber = 0;
    }

    @Override
    public void sort() {
        quickSort(0, elementsNumber - 1);
    }

    public void quickSort(int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex + 1 <= 3) {
            manualSort(leftIndex, rightIndex);
        } else {
            long pivot = medianOfThreePoints(leftIndex, rightIndex);

            int partition = partition(leftIndex, rightIndex, pivot);
            quickSort(leftIndex, partition - 1);
            quickSort(partition + 1, rightIndex);
        }
    }

    private long medianOfThreePoints(int leftIndex, int rightIndex) {
        int center = (leftIndex + rightIndex) / 2;

        if (data[leftIndex] > data[center]) {
            swap(leftIndex, center);
        } else if (data[leftIndex] > data[rightIndex]) {
            swap(leftIndex, rightIndex);
        } else if (data[center] > data[rightIndex]) {
            swap(center, rightIndex);
        }
        swap(center, rightIndex - 1);
        return data[rightIndex - 1];
    }

    private void manualSort(int leftIndex, int rightIndex) {
        int size = rightIndex - leftIndex + 1;
        if (size <= 1) {
            return;
        } if (size == 2) {
            if (data[leftIndex] > data[rightIndex]) {
                swap(leftIndex, rightIndex);
            }
        } else {
            if (data[leftIndex] > data[rightIndex - 1]) {
                swap(leftIndex, rightIndex - 1);
            }
            if (data[leftIndex] > data[rightIndex]) {
                swap(leftIndex, rightIndex);
            }
            if (data[rightIndex - 1] > data[rightIndex]) {
                swap(rightIndex - 1, rightIndex);
            }
        }
    }

    @Override
    public int partition(long pivot) {
        return partition(0, elementsNumber - 1, pivot);
    }

    private int partition(int leftIndex, int rightIndex, long pivot) {
        int leftPtr = leftIndex;
        int rightPtr = rightIndex - 1;
        while (true) {
            do {
                leftPtr += 1;
            } while (data[leftPtr] < pivot);

            do {
                rightPtr -= 1;
            } while (data[rightPtr] > pivot);

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, rightIndex - 1);
        return leftPtr;
    }

    private void swap(int index1, int index2) {
        long temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
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
    public long getMax() {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < elementsNumber; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        if (max == Long.MIN_VALUE) {
            return -1;
        } else {
            return max;
        }
    }

    @Override
    public long removeMax() {
        long max = Long.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < elementsNumber; i++) {
            if (data[i] > max) {
                max = data[i];
                maxIndex = i;
            }
        }

        if (max == Long.MIN_VALUE) {
            return -1;
        } else {
            deleteDataByIndex(maxIndex);
            return max;
        }
    }

    @Override
    public long getMin() {
        long min = Long.MAX_VALUE;
        for (int i = 0; i < elementsNumber; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }

        if (min == Long.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
    }

    @Override
    public long removeMin() {
        long min = Long.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < elementsNumber; i++) {
            if (data[i] < min) {
                min = data[i];
                minIndex = i;
            }
        }

        if (min == Long.MAX_VALUE) {
            return -1;
        } else {
            deleteDataByIndex(minIndex);
            return min;
        }
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
