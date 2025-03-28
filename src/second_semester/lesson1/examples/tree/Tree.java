package second_semester.lesson1.examples.tree;

public interface Tree {
    Node find(int key);

    Node insert(int data);

    Node delete(int key);

    void printAll();

    Node getRoot();
}
