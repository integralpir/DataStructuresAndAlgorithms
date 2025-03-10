package second_semester.lesson4.examples;

public interface Array {
    void sort();
    int partition(long pivot);
    long get(int index);
    boolean find(long key);
    void insert(long value);
    boolean delete(long value);
    void display();
    long getMax();
    long removeMax();
    long getMin();
    long removeMin();
    int actualSize();
    int maxSize();
}
