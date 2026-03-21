
public class Apartment {

    private int rooms;
    private int squares;
    private int princePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.princePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        if (squares > compared.squares) {
            return true;
        }
        return false;
    }

    public int priceDifference(Apartment compared) {
        int a1 = princePerSquare * squares;
        int a2 = compared.princePerSquare * compared.squares;

        if (a1 > a2) {
            return a1 - a2;
        }
        return a2 - a1;
    }

    public boolean moreExpensiveThan(Apartment compared) {
        if (princePerSquare * squares > compared.princePerSquare * compared.squares) {
            return true;
        }
        return false;
    }
}
