package second_semester.lesson6.examples.linearprobing;

public class LinearProbingHashTable {
    private Item[] hashArray;
    private int arraySize;

    public LinearProbingHashTable(int arraySize) {
        this.arraySize = arraySize;
        this.hashArray = new Item[arraySize];
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

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += 1;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Item temp = hashArray[hashVal];
                hashArray[hashVal] = new Item(-1);
                return temp;
            }
            hashVal += 1;
            hashVal %= arraySize;
        }
        return null;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal += 1;
            hashVal %= arraySize;
        }
        return null;
    }

    private int getPrime(int min) {
        for (int j = min + 1; true; j++) {
            if (isPrime(j)) {
                return j;
            }
        }
    }

    private boolean isPrime(int n) {
        for (int j = 2; (j * j <= n); j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}
