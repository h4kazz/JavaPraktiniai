import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {
    private ArrayList<Double> history = new ArrayList();

    public ChangeHistory() {}

    public void add(double status) {
        history.add(status);
    }

    public void clear() {
        history.clear();
    }

    @Override
    public String toString() {
        return history.toString();
    }

    public double maxValue() {
        return history.isEmpty() ? 0 : Collections.max(history);
    }

    public double minValue() {
        return history.isEmpty() ? 0 : Collections.min(history);
    }

    public double average() {
        double sum = 0;
        for (double item : history) {
            sum += item;
        }
        return sum / history.size();
    }
}
