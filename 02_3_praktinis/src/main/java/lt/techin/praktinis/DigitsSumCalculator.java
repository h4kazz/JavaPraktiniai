package lt.techin.praktinis;

public class DigitsSumCalculator {
    public void calculateSum(int number) {

        int firstNumber = number / 1000;
        int secondNumber = (number / 100) % 10;
        int thirdNumber = (number / 10) % 10;
        int fourthNumber = number % 10;

        int sum = firstNumber + secondNumber + thirdNumber + fourthNumber;
        System.out.println(sum);
    }
}
