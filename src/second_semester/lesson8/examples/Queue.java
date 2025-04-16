package second_semester.lesson8.examples;

public class Queue {
    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue(int s) {
        maxSize = s;
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public int remove() {
        int temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    public long peekFront() { // Чтение элемента в начале очереди
        return queArray[front];
    }

    public boolean isEmpty() {
        return (rear + 1 == front || (front + maxSize - 1 == rear));
    }
}