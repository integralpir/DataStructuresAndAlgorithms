package second_semester.lesson5.examples;

public interface Array {
    long get(int index);
    boolean find(long key);
    void insert(long value);
    boolean delete(long value);
    void display();
    int actualSize();
    int maxSize();
}
