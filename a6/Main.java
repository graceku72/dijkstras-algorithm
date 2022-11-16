package a6;

public class Main {


    public static void main(String[] args) {

        //You are encouraged (but not required) to include your testing code here.

        GraphImpl graph = new GraphImpl();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "D", 1);
        graph.addEdge("B", "D", 3);
        graph.addEdge("B", "E", 1);
        graph.addEdge("D", "C", 2);
        graph.addEdge("D", "F", 8);
        graph.addEdge("D", "G", 4);
        graph.addEdge("D", "E", 3);
        graph.addEdge("E", "G", 6);
        graph.addEdge("C", "A", 4);
        graph.addEdge("C", "F", 5);
        graph.addEdge("G", "F", 1);
        System.out.println(graph.dijkstra("A"));


        //Hint: Try to test basic operations (e.g., adding a few nodes and edges to graphs)
        //before you implement more complex methods


    }

}
