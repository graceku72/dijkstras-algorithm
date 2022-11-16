package a6;

public class ShortestPathQueueObjectImpl implements ShortestPathQueueObject {
    public String label;
    public double distance;

    public ShortestPathQueueObjectImpl(String label, double distance) {
        this.label = label;
        this.distance = distance;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public double getDistance() {
        return this.distance;
    }
}
