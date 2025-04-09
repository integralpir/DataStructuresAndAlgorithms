package second_semester.lesson7.examples.doublehash;

import java.util.Random;

public class DoubleHashTable {
    private Item[] hashArray;
    private int arraySize;
    private int stepSizeCounterConst;

    public DoubleHashTable(int arraySize) {
        this.arraySize = arraySize;
        this.hashArray = new Item[arraySize];
        this.stepSizeCounterConst = new Random().nextInt(1, arraySize - 1);
    }

    public void display() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println();
    }

    private int mainHashFunc(int key) {
        return key % arraySize;
    }

    private int stepSizeCounter(int key) {
        return stepSizeCounterConst - (key % stepSizeCounterConst);
    }

    public void insert(int key, Item item) {
        int hashVal = mainHashFunc(key);
        int stepSize = stepSizeCounter(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;
    }

    public Item delete(int key) {
        int hashVal = mainHashFunc(key);
        int stepSize = stepSizeCounter(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Item temp = hashArray[hashVal];
                hashArray[hashVal] = new Item(-1);
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public Item find(int key) {
        int hashVal = mainHashFunc(key);
        int stepSize = stepSizeCounter(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
