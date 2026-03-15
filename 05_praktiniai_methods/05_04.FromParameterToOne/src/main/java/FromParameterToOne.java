

public class FromParameterToOne {

    public static void main(String[] args) {

        printFromNumberToOne(5);
    }

    public static void printFromNumberToOne(int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(number - i);
        }
    }

}
