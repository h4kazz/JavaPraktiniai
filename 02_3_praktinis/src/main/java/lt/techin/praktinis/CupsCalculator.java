package lt.techin.praktinis;

public class CupsCalculator {

    public void calculateCups(int numberOfCups) {
        int packedCups = numberOfCups / 3;
        int cupsLeft = numberOfCups % 3;

        System.out.println("Deziu: " + packedCups);
        System.out.println("Liko puodeliu: " + cupsLeft);
    }

}
