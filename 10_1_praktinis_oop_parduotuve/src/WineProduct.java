import java.math.BigDecimal;

public class WineProduct extends Product {
    private int volume;
    private BigDecimal liters;

    public WineProduct(BigDecimal price, String name, int volume, BigDecimal liters) {
        super(price, name);
        this.volume = volume;
        this.liters = liters;
    }

    @Override
    public void setBrutto() {
        BigDecimal priceWithPVM = getNetto().multiply(new BigDecimal("1.21"));

        BigDecimal exciseTax;
        if (volume < 15) {
            exciseTax = liters.multiply(new BigDecimal("0.28"));
        } else {
            exciseTax = liters.multiply(new BigDecimal("0.72"));
        }

        setBrutto(priceWithPVM.add(exciseTax));
    }
}
