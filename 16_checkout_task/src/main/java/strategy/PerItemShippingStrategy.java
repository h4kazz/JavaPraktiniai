package strategy;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;

import java.math.BigDecimal;

public class PerItemShippingStrategy implements ShippingStrategy {
    private final BigDecimal ratePerItem;

    public PerItemShippingStrategy(BigDecimal ratePerItem) {
        this.ratePerItem = ratePerItem;
    }

    @Override
    public String getCode() {
        return "PER_ITEM_SHIPPING";
    }

    @Override
    public BigDecimal calculateShipping(CheckoutContext checkoutContext) {
        BigDecimal totalItems = new BigDecimal(checkoutContext.getTotalItemCount());
        return totalItems.multiply(ratePerItem);
    }
}
