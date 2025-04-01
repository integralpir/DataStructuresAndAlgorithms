package second_semester.lesson6.examples.chain;

public class LinkedList {
    private Link first;

    public void insert(Link theLink) {
        Link previous = null;
        Link current = first;

        while (current != null) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            first = theLink;
        } else {
            previous.setNext(theLink);
        }
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }
    }

    public Link find(int key) {
        Link current = first;

        while (current != null) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }
}
