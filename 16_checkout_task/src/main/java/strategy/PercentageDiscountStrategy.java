package strategy;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;

import java.math.BigDecimal;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private final BigDecimal percentage;

    public PercentageDiscountStrategy(BigDecimal percentage) {
        this.percentage = percentage.divide(new BigDecimal("100"));
    }

    @Override
    public String getCode() {
        return "PERCENTAGE_DISCOUNT";
    }

    @Override
    public BigDecimal calculateDiscount(CheckoutContext checkoutContext) {
        return checkoutContext.getItemsSubtotal().multiply(percentage);
    }
}
