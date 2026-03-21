
public class MainProgram {

    public static void main(String[] args) {
        Money firstMoneyObject = new Money(10, 0);
        Money secondMoneyObject = new Money(2, 0);
        Money tennerMinusTwoEuros = firstMoneyObject.minus(secondMoneyObject);
        System.out.println(tennerMinusTwoEuros.euros());


    }
}
