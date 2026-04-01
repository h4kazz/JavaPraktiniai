package service;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.domain.PriceBreakdown;
import academy.tasks.checkoutstrategy.service.CheckoutCalculator;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;

import java.math.BigDecimal;

public class CheckoutCalculatorImpl implements CheckoutCalculator {
    @Override
    public PriceBreakdown calculate(CheckoutContext checkoutContext, DiscountStrategy discountStrategy, ShippingStrategy shippingStrategy) {
        BigDecimal subtotal = checkoutContext.getItemsSubtotal();
        BigDecimal discount = discountStrategy.calculateDiscount(checkoutContext);

        discount = discount.min(subtotal);

        BigDecimal shipping = shippingStrategy.calculateShipping(checkoutContext);
        BigDecimal finalTotal = subtotal.subtract(discount).add(shipping);

        return new PriceBreakdown(subtotal, discount, shipping, finalTotal);
    }
}
