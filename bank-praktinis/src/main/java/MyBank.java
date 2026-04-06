import account.CreditAccount;
import account.DebitAccount;
import ibank.Account;
import ibank.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyBank implements Bank {
    List<Account> accounts = new ArrayList<>();

    @Override
    public int getNumberOfAccounts() {
        return accounts.size();
    }

    @Override
    public BigDecimal getTotalReserves() {
        if (accounts.isEmpty()) {
            return new BigDecimal("0");
        }
        return (BigDecimal) accounts.stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account openDebitAccount(String s) {
        if (accounts.stream().anyMatch(a -> a.getHolderName().equals(s))) {
            return null;
        }
        Account account = new DebitAccount(s);
        accounts.add(account);
        return account;
    }

    @Override
    public Account openCreditAccount(String s, BigDecimal bigDecimal) {
        if (accounts.stream().anyMatch(a -> a.getHolderName().equals(s))) {
            return null;
        }
        Account account = new CreditAccount(s, bigDecimal);
        accounts.add(account);
        return account;
    }

    @Override
    public Account getAccountByHolderName(String s) {
        return accounts.stream()
                .filter(a -> a.getHolderName().equals(s))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account getAccountByNumber(String s) {
        return accounts.stream()
                .filter(a -> a.getNumber().equals(s))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void closeAccount(Account account) {
        accounts.remove(account);
    }
}
