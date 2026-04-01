package strategy;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;

import java.math.BigDecimal;

public class FlatRateShippingStrategy implements ShippingStrategy {

    private BigDecimal flatRate;
    public FlatRateShippingStrategy(BigDecimal flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public String getCode() {
        return "FLAT_RATE_SHIPPING";
    }

    @Override
    public BigDecimal calculateShipping(CheckoutContext checkoutContext) {
        return flatRate;
    }
}
