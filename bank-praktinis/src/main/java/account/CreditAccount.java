package account;

import ibank.Account;

import java.math.BigDecimal;
import java.util.Random;

public class CreditAccount implements Account {
    private final String id;
    private final String name;
    private BigDecimal balance;
    private BigDecimal maxCredit;

    public CreditAccount(String name, BigDecimal maxCredit) {
        Random random = new Random();
        String number = String.format("%016d", Math.abs(random.nextLong()) % 1_000_000_000_000_0000L);

        this.id = "LT" + "01" + number;
        this.name = name;
        this.balance = BigDecimal.ZERO;
        this.maxCredit = maxCredit;
    }

    @Override
    public String getNumber() {
        return id;
    }

    @Override
    public String getHolderName() {
        return name;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(new BigDecimal(0)) < 0) {
            return false;
        }
        balance = balance.add(bigDecimal);
        return true;
    }

    @Override
    public boolean withdraw(BigDecimal bigDecimal) {
            if (balance.subtract(bigDecimal).compareTo(maxCredit.negate()) < 0) {
                return false;
            }
        balance = balance.subtract(bigDecimal);
        return true;
    }
}
