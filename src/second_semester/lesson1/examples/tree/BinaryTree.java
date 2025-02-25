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
    public Node delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.getData() != key) {
            parent = current;
            if (key < current.getData()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }

            if (current == null) {
                return null;
            }
        }

        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) {
            if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            Node successor = getSuccessor(current);
            if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }

        return current;
    }

    private Node getSuccessor(Node deletingNode) {
        Node successorParent = deletingNode;
        Node successor = deletingNode;
        Node currentNode = deletingNode.getRightChild();

        while (currentNode != null) {
            successorParent = successor;
            successor = currentNode;
            currentNode = currentNode.getLeftChild();
        }

        if (successor != deletingNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deletingNode.getRightChild());
        }

        return successor;
    }

    @Override
    public void printAll() {
        inOrder(this.root);
    }

    private void inOrder(Node currentNode) {
        if (currentNode != null) {
            inOrder(currentNode.getLeftChild());
            System.out.print(currentNode.getData() + " ");
            inOrder(currentNode.getRightChild());
        }
    }

    @Override
    public Node getRoot() {
        return root;
    }
}
