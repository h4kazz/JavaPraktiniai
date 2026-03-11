
import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give points [0-100]:");
        int points = Integer.parseInt(scan.nextLine());
        
        String grade = "";

        if (points < 0) {
            grade = "impossible!";
        } else if (points < 50) {
            grade = "failed";
        } else if (points < 60) {
            grade = String.valueOf(1);
        } else if (points < 70) {
            grade = String.valueOf(2);
        } else if (points < 80) {
            grade = String.valueOf(3);
        } else if (points < 90) {
            grade = String.valueOf(4);
        } else if (points <= 100) {
            grade = String.valueOf(5);
        } else {
            grade = "incredible!";
        }

        System.out.println("Grade: " + grade);
    }
}
