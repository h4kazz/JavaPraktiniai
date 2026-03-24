import java.math.BigDecimal;

public abstract class Product {
    private String name;
    private BigDecimal netto;
    private BigDecimal brutto;

    public Product(BigDecimal price, String name) {
        this.netto = price;
        this.name = name;
    }

    public void setBrutto(BigDecimal brutto) {
        this.brutto = brutto;
    }

    public BigDecimal getBrutto() {
        return brutto;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNetto() {
        return netto;
    }

    public abstract void setBrutto();

    @Override
    public String toString() {
        return "Product[name=" + name + ", netto=" + netto + ", brutto=" + brutto + "]";
    }
}
