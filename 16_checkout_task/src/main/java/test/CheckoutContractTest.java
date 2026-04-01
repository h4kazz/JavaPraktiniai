package test;

import academy.tasks.checkoutstrategy.service.CheckoutCalculator;
import academy.tasks.checkoutstrategy.service.CheckoutComponentFactory;
import academy.tasks.checkoutstrategy.test.AbstractCheckoutContractTest;
import service.CheckoutCalculatorImpl;
import service.CheckoutComponentFactoryImpl;

public class CheckoutContractTest extends AbstractCheckoutContractTest {
    @Override
    public CheckoutCalculator createCheckoutCalculator() {
        return new CheckoutCalculatorImpl();
    }

    @Override
    public CheckoutComponentFactory createCheckoutComponentFactory() {
        return new CheckoutComponentFactoryImpl();
    }
}
