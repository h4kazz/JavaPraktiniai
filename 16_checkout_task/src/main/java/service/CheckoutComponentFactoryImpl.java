package service;

import academy.tasks.checkoutstrategy.service.CheckoutComponentFactory;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;
import strategy.*;

import java.math.BigDecimal;

public class CheckoutComponentFactoryImpl implements CheckoutComponentFactory {

    @Override
    public DiscountStrategy createNoDiscountStrategy() {
        return new NoDiscount();
    }

    @Override
    public DiscountStrategy createPercentageDiscountStrategy(BigDecimal bigDecimal) {
        return new PercentageDiscountStrategy(bigDecimal);
    }

    @Override
    public DiscountStrategy createThresholdDiscountStrategy(BigDecimal bigDecimal, BigDecimal bigDecimal1) {
        return new ThresholdDiscountStrategy(bigDecimal, bigDecimal1);
    }

    @Override
    public ShippingStrategy createFlatRateShippingStrategy(BigDecimal bigDecimal) {
        return new FlatRateShippingStrategy(bigDecimal);
    }

    @Override
    public ShippingStrategy createFreeShippingOverThresholdStrategy(BigDecimal bigDecimal, BigDecimal bigDecimal1) {
        return new FreeShippingOverThresholdStrategy(bigDecimal, bigDecimal1);
    }

    @Override
    public ShippingStrategy createPerItemShippingStrategy(BigDecimal bigDecimal) {
        return new PerItemShippingStrategy(bigDecimal);
    }
}
