import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BasicProduct basic = new BasicProduct(new BigDecimal("100"), "Kepsnine");
        AlcoholProduct alko = new AlcoholProduct(new BigDecimal("27"), "JimBeam", 38, new BigDecimal("1"));

        Store store = new Store();

//        store.printProducts();

        store.addProduct(basic);
        store.addProduct(alko);
        store.printProducts();

        System.out.println("Calculate kepsine brutto: ");
        basic.setBrutto();
        System.out.println(basic.getBrutto());
    }
}
