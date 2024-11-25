package lesson6.examples;

import lesson6.examples.priority_queue.PriorityQueueImpl;
import lesson6.examples.queue.QueueImpl;
import lesson6.examples.stack.StackImpl;

public class Main {
    public static void main(String[] args) {
        stackExample();
        queueExample();
        priorityQueueExample();
    }

    public static void stackExample() {
        System.out.println("Stack example: ");
        StackImpl theStack = new StackImpl(10);
        theStack.push('a');
        theStack.push('b');
        theStack.push('c');
        theStack.push('d');
        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void queueExample() {
        System.out.println("Queue example: ");
        QueueImpl theQueue = new QueueImpl(5);
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);
        while (!theQueue.isEmpty()){
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void priorityQueueExample() {
        System.out.println("Priority queue example: ");
        PriorityQueueImpl thePQ = new PriorityQueueImpl(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        while (!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
