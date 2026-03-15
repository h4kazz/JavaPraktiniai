public class Clock {
    public static void main(String[] args) {

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                System.out.printf("%02d:%02d\n", i, j);
            }
        }
    }
}