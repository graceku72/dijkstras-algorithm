package a6;

import java.util.*;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //Do not delete.  Use this field to store your nodes.
                             // key: name of node. value: a5.Node object associated with name
    int edgeCount;

    public GraphImpl() {
        nodes = new HashMap<>();
    }

    @Override
    public boolean addNode(String name) {
        if (nodes.containsKey(name) || name == null) {
            return false;
        }
        Node newNode = new NodeImpl(name);
        nodes.put(name, newNode);
        return true;
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (weight < 0 || nodes.containsKey(src) == false || nodes.containsKey(dest) == false || nodes.get(src).checkEdge(dest)) {
            return false;
        }
        Edge newEdge = new EdgeImpl(nodes.get(src), nodes.get(dest), weight);
        nodes.get(src).addEdge(newEdge);
        edgeCount += 1;
        nodes.get(dest).increaseInDegree();
        return true;
    }

    @Override
    public boolean deleteNode(String name) {
        //Hint: Do you need to remove edges when you delete a node?
        if (!nodes.containsKey(name)) {
            return false;
        }
        ArrayList<Edge> delEdges = new ArrayList<Edge>();
        for (Node node : nodes.values()) {
            for (Edge edge : node.getEdges()) {
                if (edge.getDestination().getName().equals(name)) {
                    delEdges.add(edge);
                }
            }
        }
        for (Edge edge : delEdges) {
            deleteEdge(edge.getSource().getName(), edge.getDestination().getName());
        }
        nodes.remove(name);
        return true;
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if (!nodes.containsKey(src) || !nodes.containsKey(dest)) {
            return false;
        }
        Node source = nodes.get(src);
        Node destination = nodes.get(dest);
        boolean result = source.deleteEdge(dest);
        if (result) {
            edgeCount -= 1;
            destination.decreaseInDegree();
            return true;
        }
        return false;
    }

    @Override
    public int numNodes() {
        return nodes.size();
    }

    @Override
    public int numEdges() {
        return edgeCount;
    }

    @Override
    public Map<String, Double> dijkstra(String start) {
        Comparator<ShortestPathQueueObject> compare = (a, b) -> Double.compare(a.getDistance(), b.getDistance());
        PriorityQueue<ShortestPathQueueObject> queue = new PriorityQueue<ShortestPathQueueObject>(compare);
        Map<String, Double> dijkstraAlg = new HashMap<String, Double>();
        Set<String> visited = new HashSet<String>();
        nodes.get(start).setDistance(0);
        ShortestPathQueueObjectImpl startNode = new ShortestPathQueueObjectImpl(start, 0);
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node n = nodes.get(queue.peek().getLabel());
            double d = queue.peek().getDistance();
            if (!visited.contains(n.getName())) {
                dijkstraAlg.put(n.getName(), n.getDistance());
                visited.add(n.getName());
                for (Edge e : n.getEdges()) {
                    if (!visited.contains(e.getDestination())) {
                        if (e.getDestination().getDistance() > d + e.getWeight()) {
                            e.getDestination().setDistance(d + e.getWeight());
                        }
                        ShortestPathQueueObjectImpl enque = new ShortestPathQueueObjectImpl(e.getDestination().getName(), e.getDestination().getDistance());
                        queue.add(enque);
                    }
                }
            }
            queue.poll();
        }
        return dijkstraAlg;
    }
}
