package second_semester.lesson6.examples.chain;

public class Link {
    private final int key;
    private Link next;

    public Link(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public void displayLink() {
        System.out.print(key + " ");
    }
}
