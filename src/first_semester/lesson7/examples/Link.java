package first_semester.lesson7.examples;

public class Link {
    private int data;
    private Link next;

    public Link(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print("{" + data + "} ");
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
