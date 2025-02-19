package second_semester.lesson1.examples;

import second_semester.lesson1.examples.tree.BinaryTree;
import second_semester.lesson1.examples.tree.Node;
import second_semester.lesson1.examples.tree.Tree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree tree = new BinaryTree(new Node(50));
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(63);
        tree.insert(50);

        int existingKey = 12;
        int unknownKey = 100;

        List.of(existingKey, unknownKey).forEach(key -> {
            Node node = tree.find(key);

            if (node == null) {
                System.out.println("Узел с ключом " + key + " не найден.");
            } else {
                System.out.println("Узел с ключом " + key + " найден. Узел " + node);
            }
        });
    }
}
