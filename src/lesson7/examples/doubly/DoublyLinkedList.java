package lesson7.examples.doubly;

public class DoublyLinkedList {
    private DoublyLink first;
    private DoublyLink last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        DoublyLink newLink = new DoublyLink(data);
        if (this.isEmpty()) {
            last = newLink;
        } else {
            first.setPrevious(newLink);
        }
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(int data) {
        DoublyLink newLink = new DoublyLink(data);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
    }

    public DoublyLink deleteFirst() {
        DoublyLink temp = first;
        if (first.getNext() == null) {
            last = null;
        } else {
            first.getNext().setPrevious(null);
        }
        first = first.getNext();
        return temp;
    }

    public DoublyLink deleteLast() {
        DoublyLink temp = last;
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrevious().setNext(null);
        }
        last = last.getPrevious();
        return temp;
    }

    public boolean insertAfter(int key, int data) {
        DoublyLink current = first;

        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                return false;
            }
        }

        DoublyLink newLink = new DoublyLink(data);
        if (current == last) {
            newLink.setNext(null);
            last = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.getNext().setPrevious(newLink);
        }
        newLink.setPrevious(current);
        current.setNext(newLink);
        return true;
    }

    public DoublyLink deleteKey(long key) {
        DoublyLink current = first;
        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.getNext();
        } else {
            current.getPrevious().setNext(current.getNext());
        }

        if (current == last) {
            last = current.getPrevious();
        } else {
            current.getNext().setPrevious(current.getPrevious());
        }
        return current;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoublyLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoublyLink current = last;
        while (current != null) {
            current.displayLink();
            current = current.getPrevious();
        }
        System.out.println();
    }
}