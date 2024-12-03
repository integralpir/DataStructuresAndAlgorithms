package lesson7.examples.simple;

import lesson7.examples.Link;
import lesson7.examples.LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList linkedList = new SimpleLinkedList();

        linkedList.insertFirst(22);
        linkedList.insertFirst(44);
        linkedList.insertFirst(66);
        linkedList.insertFirst(88);
        linkedList.displayList();

        while (!linkedList.isEmpty()) {
            Link aLink = linkedList.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayLink();
            System.out.println();
        }

        linkedList.displayList();

        linkedList.insertFirst(22);
        linkedList.insertFirst(44);
        linkedList.insertFirst(66);
        linkedList.insertFirst(88);
        linkedList.displayList();

        Link lookingElement = linkedList.find(44);
        if (lookingElement != null) {
            System.out.println("Found link with key " + lookingElement.getData());
        } else {
            System.out.println("Can’t find link");
        }

        Link deletedElement = linkedList.delete(66);
        if (deletedElement != null) {
            System.out.println("Deleted link with key " + deletedElement.getData());
        } else {
            System.out.println("Can’t delete link");
        }
        linkedList.displayList();
    }
}
