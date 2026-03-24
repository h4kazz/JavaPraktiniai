import java.math.BigDecimal;

public class BasicProduct extends Product {

    public BasicProduct(BigDecimal price, String name) {
        super(price, name);
    }

    @Override
    public void setBrutto() {
        BigDecimal PVM = new BigDecimal("1.21");
        setBrutto(getNetto().multiply(PVM));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
