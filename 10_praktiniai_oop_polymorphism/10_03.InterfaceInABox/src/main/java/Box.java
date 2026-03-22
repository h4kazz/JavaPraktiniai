import java.util.ArrayList;

public class Box implements Packable {
    private double weight = 0;
    private ArrayList<Packable> items = new ArrayList<>();

    public Box(double weight) {
        this.weight = weight;
    }

    public void add(Packable item) {
        if (weight() + item.weight() <= weight) {
            items.add(item);
        }
    }



    @Override
    public double weight() {
        double total = 0;
        for (Packable item : items) {
            total += item.weight();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
}
