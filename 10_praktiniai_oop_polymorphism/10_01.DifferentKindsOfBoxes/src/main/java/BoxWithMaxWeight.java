import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> items = new ArrayList<>();

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
    }



    @Override
    public void add(Item item) {
        int totalWeight = 0;
        for (Item itm : items) {
            totalWeight += itm.getWeight();
        }

        if (totalWeight + item.getWeight() <= capacity) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        for (Item itm : items) {
            if (itm.equals(item)) {
                return true;
            }
        }
        return false;
    }
}