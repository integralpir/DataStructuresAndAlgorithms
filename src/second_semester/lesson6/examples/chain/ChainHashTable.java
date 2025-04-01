package second_semester.lesson6.examples.chain;

public class ChainHashTable {
    private LinkedList[] hashArray;
    private int arraySize;

    public ChainHashTable(int size) {
        arraySize = size;
        hashArray = new LinkedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new LinkedList();
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }
}
