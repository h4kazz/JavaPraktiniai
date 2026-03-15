
public class Smallest {

    public static int smallest(int number1, int number2) {
        int minNumber = 0;
        if (number1 < number2) {
            minNumber = number1;
        } else {
            minNumber = number2;
        }
        return minNumber;
    }

    public static void main(String[] args) {
        int result = smallest(2, 7);
        System.out.println("Smallest: " + result);
    }
}
