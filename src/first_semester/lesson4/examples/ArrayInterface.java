package first_semester.lesson4.examples;

public interface ArrayInterface {
    boolean contains(long searchValue);
    boolean insert(long value);
    boolean delete(long value);
    void display();
    int getSize();
    long getMax();
    long getMin();
}
