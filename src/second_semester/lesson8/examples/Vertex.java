package second_semester.lesson8.examples;

public class Vertex {
    private final char label;
    private boolean isVisited;

    public Vertex(char label) {
        this.label = label;
        this.isVisited = false;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public char getLabel() {
        return label;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
