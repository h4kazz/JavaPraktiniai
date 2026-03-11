
import java.sql.SQLOutput;
import java.util.Scanner;

public class DifferentTypesOfInput {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give a string:");
        String text = scan.nextLine();

        System.out.println("Give an integer:");
        int intNumber = Integer.parseInt(scan.nextLine());

        System.out.println("Give a double:");
        double doubleNumber = Double.parseDouble(scan.nextLine());

        System.out.println("Give a boolean:");
        boolean trueOrFalse = Boolean.parseBoolean(scan.nextLine());

        System.out.println("You gave the string " + text);
        System.out.println("You gave the integer " + intNumber);
        System.out.println("You gave the double " + doubleNumber);
        System.out.println("You gave the boolean " + trueOrFalse);

    }
}
