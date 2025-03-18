package second_semester.lesson5.examples;

public class OrderedArray implements Array {
    private final long[] data;
    private int elementsNumber;

    public OrderedArray(int size) {
        this.data = new long[size];
        this.elementsNumber = 0;
    }

    @Override
    public boolean find(long key) {
        return recursionBinarySearch(key, 0, elementsNumber - 1);
    }

    private boolean recursionBinarySearch(long searchKey, int lowerBound, int upperBound) {
        int currentIndex = (lowerBound + upperBound) / 2;

        if (data[currentIndex] == searchKey) {
            return true;
        } else if (lowerBound > upperBound) {
            return false;
        } else {
            if (data[currentIndex] < searchKey) {
                return recursionBinarySearch(searchKey, currentIndex + 1, upperBound);
            } else {
                return recursionBinarySearch(searchKey, lowerBound, currentIndex - 1);
            }
        }
    }

    @Override
    public long get(int index) {
        return data[index];
    }

    @Override
    public void insert(long value) {
        if (this.find(value)) {
            return;
        }

        int i;
        for (i = 0; i < elementsNumber; i++) {
            if (data[i] > value) {
                break;
            }
        }

        for (int j = elementsNumber; j > i; j--) {
            data[j] = data[j - 1];
        }

        data[i] = value;
        elementsNumber++;
    }

    @Override
    public boolean delete(long value) {
        int i;
        for (i = 0; i < this.elementsNumber; i++) {
            if (data[i] == value) {
                break;
            }
        }

        if (i == elementsNumber - 1) {
            return false;
        } else {
            for (int j = i; j < elementsNumber - 1; j++) {
                data[j] = data[j + 1];
            }
            elementsNumber--;
            return true;
        }
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
        return this.elementsNumber;
    }

    @Override
    public int maxSize() {
        return this.data.length;
    }
}
