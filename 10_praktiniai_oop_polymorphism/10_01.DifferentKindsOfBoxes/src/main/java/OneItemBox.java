import java.util.ArrayList;

public class OneItemBox extends Box{
    private final int capacity = 1;
    private ArrayList<Item> items = new ArrayList();

    public OneItemBox() {};


    @Override
    public void add(Item item) {
        if (items.size() < 1) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
