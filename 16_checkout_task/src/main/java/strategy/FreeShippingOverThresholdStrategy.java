package strategy;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;

import java.math.BigDecimal;

public class FreeShippingOverThresholdStrategy implements ShippingStrategy {
    private final BigDecimal subtotalThreshold;
    private final BigDecimal standardShippingCost;

    public FreeShippingOverThresholdStrategy(BigDecimal subtotalThreshold, BigDecimal standardShippingCost) {
        this.subtotalThreshold = subtotalThreshold;
        this.standardShippingCost = standardShippingCost;
    }

    @Override
    public String getCode() {
        return "SHIPPING_OVER_THRESHOLD";
    }

    @Override
    public BigDecimal calculateShipping(CheckoutContext checkoutContext) {
        if (!subtotalThreshold.equals(checkoutContext.getItemsSubtotal())) {
            return standardShippingCost;
        }
        return BigDecimal.ZERO;
    }
}
