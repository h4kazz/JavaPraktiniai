package lt.account;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        DebitAccount debit = new DebitAccount(1001, "Matas", new BigDecimal("150"));
        System.out.println("Debit account:");
        System.out.println(debit.toString());
        System.out.println("=================================================");

        debit.deposit(new BigDecimal("20"));
        System.out.println("=================================================");

        System.out.println("Credit account:");
        CreditAccount credit = new CreditAccount(1002, "Matas", new BigDecimal("500"));
        System.out.println(credit.toString());
        System.out.println("=================================================");
        credit.withdraw(new BigDecimal("800"));
    }
}
