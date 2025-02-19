package second_semester.lesson1.examples.tree;

public class BinaryTree implements Tree {
    private final Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public Node find(int key) {
        // Вывод для наглядности процесса
        System.out.println("_____________________________________________");
        System.out.println("Процесс поиска узла с ключом " + key + " запущен...");
        Node currentNode = root;

        while (currentNode != null && currentNode.getData() != key) {
            // Вывод для наглядности процесса
            System.out.println("Проверяем узел с ключом " + currentNode.getData());
            if (key < currentNode.getData()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }

        return currentNode;
    }

    @Override
    public Node insert(int data) {
        // Вывод для наглядности процесса
        System.out.println("_____________________________________________");
        System.out.println("Процесс вставки узла с ключом " + data + " запущен...");
        Node currentNode = root;
        Node newNode = null;

        while (newNode == null) {
            // Вывод для наглядности процесса
            System.out.println("Проверяем узел с ключом " + currentNode.getData());
            if (currentNode.getData() == data) {
                newNode = currentNode;
                // Вывод для наглядности процесса
                System.out.println("Узел уже существует.");
            } else if (data < currentNode.getData()) {
                if (currentNode.getLeftChild() == null) {
                    newNode = new Node(data);
                    currentNode.setLeftChild(newNode);
                    // Вывод для наглядности процесса
                    System.out.println("Узел был вставлен в левую ветку.");
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            } else if (data > currentNode.getData()) {
                if (currentNode.getRightChild() == null) {
                    newNode = new Node(data);
                    currentNode.setRightChild(newNode);
                    // Вывод для наглядности процесса
                    System.out.println("Узел был вставлен в правую ветку.");
                } else {
                    currentNode = currentNode.getRightChild();
                }
            }
        }

        return newNode;
    }

    @Override
    public Node getRoot() {
        return root;
    }
}
