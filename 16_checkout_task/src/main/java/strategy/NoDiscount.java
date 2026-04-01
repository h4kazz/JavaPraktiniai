package strategy;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;

import java.math.BigDecimal;

public class NoDiscount implements DiscountStrategy {
    @Override
    public String getCode() {
        return "NO_DISCOUNT";
    }

    @Override
    public BigDecimal calculateDiscount(CheckoutContext checkoutContext) {
        return BigDecimal.ZERO;
    }
}
