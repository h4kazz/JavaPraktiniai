import java.util.ArrayList;

public class Store {
    private ArrayList<Product> products = new ArrayList<>();
    private Product product;

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
            }
        }
    }

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("Store doesn't have products anymore! Come back tomorrow.");
        }
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}
