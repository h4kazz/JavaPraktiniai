package lt.account;

import java.math.BigDecimal;

public class CreditAccount extends Account{
    private final BigDecimal maxLoan;

    public CreditAccount(int id, String holder, BigDecimal balance) {
        super(id, holder, balance);
        this.maxLoan = balance;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (getBalance().subtract(amount).compareTo(maxLoan.negate()) < 0) {
            throw  new IllegalArgumentException("Credit can not be lower than " + maxLoan);
        }
        setBalance(getBalance().subtract(amount));
        System.out.println("Amount debited: " + amount + ", new balance: " + getBalance());
    }

    @Override
    public String toString() {
        return "AccountId: " + getId() + "\nHolder name: " + getHolder() + "\nBalance: " + getBalance() + " Eur" + "\nMax credit: " + maxLoan + " Eur";
    }
}
