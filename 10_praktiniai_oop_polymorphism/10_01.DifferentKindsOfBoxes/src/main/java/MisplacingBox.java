import java.util.ArrayList;

public class MisplacingBox extends Box{
    private ArrayList<Item> items = new ArrayList<>();

    public MisplacingBox() {};

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
