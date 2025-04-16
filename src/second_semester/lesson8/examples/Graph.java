package second_semester.lesson8.examples;

public class Graph {
    private final int maxVertex;
    private Vertex[] vertexList;
    private int[][] matrix;
    private int vertexNumber;
    private Stack stack;
    private Queue queue;

    public Graph(int maxVertex) {
        this.maxVertex = maxVertex;
        this.vertexList = new Vertex[maxVertex];
        this.matrix = new int[maxVertex][maxVertex];
        this.vertexNumber = 0;
        for (int i = 0; i < maxVertex; i++) {
            for (int j = 0; j < maxVertex; j++) {
                this.matrix[i][j] = 0;
            }
        }
        this.stack = new Stack(maxVertex);
        this.queue = new Queue(maxVertex);
    }

    public void addVertex(char label) {
        vertexList[vertexNumber++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        matrix[start][end] = 1;
        matrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].getLabel());
    }

    public void depthFirstTraversal() {
        vertexList[0].setVisited(true);
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].setVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < vertexNumber; i++) {
            vertexList[i].setVisited(false);
        }
    }

    public void breadthFirstTraversal() { // Обход в ширину
    // Алгоритм начинает с вершины 0
        vertexList[0].setVisited(true); // Пометка
        displayVertex(0); // Вывод
        queue.insert(0); // Вставка в конец очереди

        int v2;
        while (!queue.isEmpty()) { // Пока очередь не опустеет
            int v1 = queue.remove(); // Извлечение вершины в начале очереди

            while ((v2 = getUnvisitedVertex(v1)) != -1) { // Получение вершины
                vertexList[v2].setVisited(true); // Пометка
                displayVertex(v2); // Вывод
                queue.insert(v2); // Вставка
            }
        }

        // Очередь пуста, обход закончен
        for (int i = 0; i < vertexNumber; i++) { // Сброс флагов
            vertexList[i].setVisited(false);
        }
    }

    private int getUnvisitedVertex(int index) {
        for (int i = 0; i < vertexNumber; i++) {
            if (matrix[index][i] == 1 && !vertexList[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }
}
