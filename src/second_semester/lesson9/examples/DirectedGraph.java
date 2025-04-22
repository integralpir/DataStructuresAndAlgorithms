package second_semester.lesson9.examples;

public class DirectedGraph {
    private final int maxVertex;
    private Vertex[] vertexList;
    private int[][] matrix;
    private int vertexNumber;
    private Stack stack;

    public DirectedGraph(int maxVertex) {
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
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].getLabel());
    }

    public void topologicSearch() {
        int originVertexNumber = vertexNumber; // Сохранение количества вершин
        char[] sortedArray = new char[maxVertex];
        while (vertexNumber > 0) {  // Пока в графе остаются вершины
            // Получение вершины без преемников или -1
            int currentVertex = getNoSuccessorsVertex();
            if (currentVertex == -1) { // В графе есть цикл
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            // Вставка метки вершины в массив (начиная с конца)
            sortedArray[vertexNumber - 1] = vertexList[currentVertex].getLabel();

            deleteVertex(currentVertex); // Удаление вершины
        }

        // Все вершины удалены, вывод содержимого sortedArray
        System.out.print("Topologically sorted order: ");
        for (int j = 0; j < originVertexNumber; j++) {
            System.out.print(sortedArray[j]);
        }
        System.out.println();
    }

    private int getNoSuccessorsVertex() { // Метод возвращает вершину, не имеющую преемников (или -1, если ее нет)
        boolean isEdge;  // Ребро в матрице adjMat, ведущее от row в column

        for (int row = 0; row < vertexNumber; row++) { // Для каждой вершины
            isEdge = false; // Проверка ребер
            for (int col = 0; col < vertexNumber; col++) {
                if (matrix[row][col] > 0) { // Если существует ребро
                    isEdge = true; // У вершины имеется преемник
                    break;
                }
            }
            if (!isEdge) { // Если ребер нет, то нет и преемников
                return row;
            }
        }

        return -1; // Вершина не найдена
    }

    private void deleteVertex(int deletedVertexIndex) {
        if (deletedVertexIndex != vertexNumber - 1) { // Если вершина не последняя Удаление из vertexList
            for (int i = deletedVertexIndex; i < vertexNumber - 1; i++) {
                vertexList[i] = vertexList[i + 1];
            }
            for (int row = deletedVertexIndex; row < vertexNumber - 1; row++) {
                moveRowUp(row, vertexNumber); // удаление строки из matrix
            }
            for (int col = deletedVertexIndex; col < vertexNumber - 1; col++) {
                moveColLeft(col, vertexNumber - 1); // Удаление столбца из matrix
            }
            vertexNumber--; // Количество вершин уменьшается на 1
        }
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            matrix[row][col] = matrix[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            matrix[row][col] = matrix[row][col + 1];
        }
    }
}
