package second_semester.lesson9.examples;

public class Graph {
    private final int maxVertex;
    private Vertex[] vertexList;
    private int[][] matrix;
    private int vertexNumber;
    private Stack stack;

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

    public void minimalSpanningTree() {
        while (!stack.isEmpty()) {
            int currentVertexIndex = stack.peek();
            int vertex = getUnvisitedVertex(currentVertexIndex);

            if (vertex == -1) {
                stack.pop();
            } else {
                vertexList[vertex].setVisited(true);
                stack.push(vertex);

                displayVertex(currentVertexIndex);
                displayVertex(vertex);
                System.out.print(" ");
            }
        }

        for (int i = 0; i < vertexNumber; i++) {
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
