package strategy;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;

import java.math.BigDecimal;

public class ThresholdDiscountStrategy implements DiscountStrategy {
    private final BigDecimal subtotalThreshold;
    private final BigDecimal discountAmount;

    public ThresholdDiscountStrategy(BigDecimal subtotalThreshold, BigDecimal discountAmount) {
        this.subtotalThreshold = subtotalThreshold;
        this.discountAmount = discountAmount;
    }


    @Override
    public String getCode() {
        return "THRESHOLD_DISCOUNT";
    }

    @Override
    public BigDecimal calculateDiscount(CheckoutContext checkoutContext) {
        if (!subtotalThreshold.equals(checkoutContext.getItemsSubtotal())) {
            return BigDecimal.ZERO;
        }
        return this.discountAmount;
    }
}
