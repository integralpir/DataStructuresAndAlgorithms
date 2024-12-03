package lesson7.examples.simple;

import lesson7.examples.Link;
import lesson7.examples.LinkedList;

public class SimpleLinkedList implements LinkedList {
    private Link first;

    public SimpleLinkedList() {
        first = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void insertFirst(int data) {
        Link newLink = new Link(data);
        newLink.setNext(first);
        first = newLink;
    }

    @Override
    public Link deleteFirst() {
        Link temp = first;
        first = temp.getNext();
        return temp;
    }

    public Link find(int key) {
        Link current = first;
        while (current.getData() != key) {
            if(current.getNext() == null) {
                return null;
            } else {
                current = current.getNext();
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        while (current.getData() != key) {
            if(current.getNext() == null) {
                return null;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (current == first) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        return current;
    }

    @Override
    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while(current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }
}
