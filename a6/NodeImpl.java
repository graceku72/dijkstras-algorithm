package a6;

import java.util.ArrayList;

public class NodeImpl implements Node {

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any node fields you want to add for the object should go in this file.  */
    private String name;
    private ArrayList<Edge> edges;
    private int inDegree;
    private double distance;

    public NodeImpl(String name) {
        this.name = name;
        this.edges = new ArrayList<Edge>();
        this.inDegree = 0;
        this.distance = Double.MAX_VALUE;
    }

    @Override
    public double getDistance() {
        return this.distance;
    }

    @Override
    public void setDistance(double dv) {
        this.distance = dv;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    @Override
    public void addEdge(Edge newEdge) {
        this.edges.add(newEdge);
    }

    @Override
    public boolean checkEdge(String nodeName) {
        if (this.edges.size() == 0) {
            return false;
        }
        for (int i = 0; i < this.edges.size(); i++) {
            Edge curr = this.edges.get(i);
            if (curr.getDestination().getName().equals(nodeName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteEdge(String nodeName) {
        if (checkEdge(nodeName) == false) {
            return false;
        }
        for (int i = 0; i < this.edges.size(); i++) {
            Edge curr = this.edges.get(i);
            if (curr.getDestination().getName().equals(nodeName)) {
                this.edges.remove(curr);
                return true;
            }
        }
        return false;
    }

    public int getInDegree() {
        return this.inDegree;
    }

    @Override
    public int increaseInDegree() {
        return this.inDegree += 1;
    }

    @Override
    public int decreaseInDegree() {
        return this.inDegree -= 1;
    }

}
