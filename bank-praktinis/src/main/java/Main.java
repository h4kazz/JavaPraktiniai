import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        String number = String.format("%016d", Math.abs(random.nextLong()) % 1_000_000_000_000_0000L);
        String iban = "LT" + "01" + number;

        System.out.println(iban);
    }
}

