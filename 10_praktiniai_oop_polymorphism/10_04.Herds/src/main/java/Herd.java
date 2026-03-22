import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {
    private List<Movable> organisms = new ArrayList<>();

    public void addToHerd(Movable movable) {
        organisms.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable organism : organisms) {
            organism.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Movable organism : organisms) {
            result += organism.toString() + "\n";
        }
        return result;
    }
}
