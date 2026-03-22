public class ProductWarehouse extends Warehouse {
    private String productName;

    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.productName = productName;
    }

    public ProductWarehouse(String productName, double capacity, double initialBalance) {
        super(capacity, initialBalance);
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    @Override
    public String toString() {
        return productName + ": " + super.toString();
    }
}
