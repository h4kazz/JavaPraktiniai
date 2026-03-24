import java.math.BigDecimal;

public class MedicineProduct extends Product {
    public MedicineProduct(BigDecimal price, String name) {
        super(price, name);
    }

    @Override
    public void setBrutto() {
        BigDecimal PVM = new BigDecimal("1.09");
        setBrutto(getNetto().multiply(PVM));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
