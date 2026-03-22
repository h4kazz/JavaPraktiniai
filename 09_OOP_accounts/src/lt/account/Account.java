package lt.account;

import java.math.BigDecimal;

public abstract class Account {
    private final int id;
    private final String holder;
    private BigDecimal balance;


    public Account(int id, String holder, BigDecimal balance) {
        this.id = id;
        this.holder = holder;
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public String getHolder() {
        return this.holder;
    }

    public void setBalance(BigDecimal amount) {
        this.balance = amount;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void deposit(BigDecimal amount) {
        this.balance = balance.add(amount);
        System.out.println("Amount credited: " + amount + ", new balance: " + balance);
    }

    @Override
    public String toString() {
        return "AccountId: " + id + "\nHolder name: " + holder + "\nBalance: " + balance + " Eur";
    }

    public abstract void withdraw(BigDecimal amount);
}
