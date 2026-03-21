
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        Money newMoney = new Money(addition.euros() + euros, addition.cents() + cents);
        return newMoney;
    }

    public boolean lessThan(Money compared) {
        if (euros < compared.euros()) {
            return true;
        } else if (euros == compared.euros() && cents < compared.cents()) {
            return true;
        }
        return false;
    }

    public Money minus(Money decreaser) {
        int thisCents = this.euros * 100 + this.cents;
        int decreaseCents = decreaser.euros() * 100 + decreaser.cents();
        if (thisCents < decreaseCents) {
            return new Money(0, 0);
        }
        int totalCents = thisCents - decreaseCents;
        return new Money(totalCents / 100, totalCents % 100);
    }

}
