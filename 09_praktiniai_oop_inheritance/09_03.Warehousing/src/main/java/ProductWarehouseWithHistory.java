import java.util.ArrayList;

public class ProductWarehouseWithHistory extends ProductWarehouse {
//    private double balance;
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity, initialBalance);
        this.history = new ChangeHistory();
        history.add(initialBalance);
    }

    public String history() {
        return history.toString();
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        history.add(getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double taken = super.takeFromWarehouse(amount);
        history.add(getBalance());
        return taken;
    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName() +
                "\nHistory: " + history.toString() +
                "\nLargest amount of product: " + history.maxValue() +
                "\nSmallest amount of product: " + history.minValue() +
                "\nAverage: " + history.average());
    }


}
