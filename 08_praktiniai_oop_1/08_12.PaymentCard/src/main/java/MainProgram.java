
public class MainProgram {

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        
        PaymentCard Paul = new PaymentCard(20);

        PaymentCard Matt = new PaymentCard(30);

        Paul.eatHeartily();
        System.out.println("Paul: " + Paul.toString());

        Matt.eatAffordably();
        System.out.println("Matt: " + Matt.toString());

        Paul.addMoney(20);
        System.out.println("Paul: " + Paul.toString());

        Matt.eatHeartily();
        System.out.println("Matt: " + Matt.toString());

        Paul.eatHeartily();
        System.out.println("Paul: " + Paul.toString());
        
        Matt.addMoney(50);
        System.out.println("Matt: " + Matt.toString());


    }
}
