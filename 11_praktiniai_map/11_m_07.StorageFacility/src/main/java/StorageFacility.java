import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storage = new HashMap<>();

    public void add(String unit, String item) {
        if (!storage.containsKey(unit)) {
            storage.put(unit, new ArrayList<>());
        }
        storage.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        if (storage.containsKey(storageUnit)) {
            return storage.get(storageUnit);
        }
        return new ArrayList<>();
    }

    public void remove(String storageUnit, String item) {
        if (storage.containsKey(storageUnit)) {
            storage.get(storageUnit).remove(item);
        }
    }

    public ArrayList<String> storageUnits() {
        return storage.entrySet().stream()
                .filter(e -> !e.getValue().isEmpty())
                .map(e -> e.getKey())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
