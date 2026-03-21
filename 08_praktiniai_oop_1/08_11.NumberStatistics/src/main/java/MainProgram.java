
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // you can write test code here
        // however, remove all unnecessary code when doing the final parts of the exercise

        // In order for the tests to work, the objects must be created in the
        // correct order in the main program. First the object that tracks the total
        // sum, secondly the object that tracks the sum of even numbers, 
        // and lastly the one that tracks the sum of odd numbers!

        Statistics statistics = new Statistics();
        Statistics statistics1 = new Statistics();
        Statistics statistics2 = new Statistics();

//        statistics.addNumber(3);
//        statistics.addNumber(2);
//        statistics.addNumber(1);
//        statistics.addNumber(5);
//
//        System.out.println("Count: " + statistics.getCount());

        System.out.println("Enter numbers:");

//        int number = 0;
//
//        while (number != -1) {
//                number = Integer.parseInt(scanner.nextLine());
//                if (number != -1) {
//                    statistics.addNumber(number);
//                }
//        }
//
//        System.out.println("Sum: " + statistics.sum());

        int number = 0;

                while (number != -1) {
                number = Integer.parseInt(scanner.nextLine());
                if (number != -1) {
                    statistics.addNumber(number);
                    if (number % 2 == 0) {
                        statistics1.addNumber(number);
                    } else {
                        statistics2.addNumber(number);
                    }
                }
        }

        System.out.println("Sum: " + statistics.sum());
        System.out.println("Sum of even numbers: " + statistics1.sum());
        System.out.println("Sum of odd numbers: " + statistics2.sum());


    }
}
