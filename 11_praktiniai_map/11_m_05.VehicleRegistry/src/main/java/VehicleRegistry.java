import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> hashMap = new HashMap<>();

    public boolean add(LicensePlate licensePlate, String owner) {
        if (hashMap.containsKey(licensePlate)) {
            return false;
        }

        hashMap.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        return hashMap.getOrDefault(licensePlate, null);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (!hashMap.containsKey(licensePlate)) {
            return false;
        }
        hashMap.remove(licensePlate);
        return true;
    }

    public void printLicensePlates() {
        for (LicensePlate plate : hashMap.keySet()) {
            System.out.println(plate);
        }

    }

    public void printOwners() {
        Set<String> owners = new HashSet<>(hashMap.values());
        for (String owner : owners) {
            System.out.println(owner);
        }
    }
}
