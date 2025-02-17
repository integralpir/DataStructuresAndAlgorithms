package first_semester.lesson7.examples.doubly;

public class DoublyLink {
    private int data;
    private DoublyLink next;
    private DoublyLink previous;

    public DoublyLink(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print("{" + data + "} ");
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLink getNext() {
        return next;
    }

    public void setNext(DoublyLink next) {
        this.next = next;
    }

    public DoublyLink getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLink previous) {
        this.previous = previous;
    }
}
