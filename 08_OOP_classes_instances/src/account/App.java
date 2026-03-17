package account;

public class App {
    public static void main(String[] args) {
        Account firstAccount = new Account("LT00001", "personal");
        Account secondAccount = new Account("LT00002", "business");

        System.out.println("Account ids:");
        System.out.println(firstAccount.getId());
        System.out.println(secondAccount.getId());
        System.out.println("---------------------");

        System.out.println("Account names:");
        System.out.println(firstAccount.getName());
        System.out.println(secondAccount.getName());
        System.out.println("---------------------");

        System.out.println("Account balances:");
        System.out.println(firstAccount.getBalance());
        System.out.println(secondAccount.getBalance());
        System.out.println("---------------------");

        System.out.println("Add money to accounts:");
        System.out.println(firstAccount.credit(10));
        System.out.println(secondAccount.credit(15));
        System.out.println("---------------------");

        System.out.println("Withdraw money from accounts:");
        System.out.println(firstAccount.debit(2));
        System.out.println(secondAccount.debit(5));
        System.out.println("---------------------");

        System.out.println("Transfer from personal to business:");
        System.out.println(firstAccount.transferTo(secondAccount, 3));
        System.out.println("Business balance after transfer");
        System.out.println(secondAccount.getBalance());
        System.out.println("---------------------");

        System.out.println("toString method:");
        System.out.println(firstAccount.toString());
        System.out.println(secondAccount.toString());
        System.out.println("---------------------");
    }
}