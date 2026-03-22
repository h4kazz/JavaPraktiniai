package lt.account;

import java.math.BigDecimal;

public class DebitAccount extends Account {

    public DebitAccount(int id, String holder, BigDecimal balance) {
        super(id, holder, balance);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(getBalance()) > 0) {
            throw new IllegalArgumentException("Not enough funds");
        }
        setBalance(getBalance().subtract(amount));
        System.out.println("Amount debited: " + amount + ", new balance: " + getBalance());
    }
}
