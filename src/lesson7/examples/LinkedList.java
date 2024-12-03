package lesson7.examples;

public interface LinkedList {
    boolean isEmpty();
    void insertFirst(int data);
    Link deleteFirst();
    void displayList();
    Link find(int key);
    Link delete(int key);
}
