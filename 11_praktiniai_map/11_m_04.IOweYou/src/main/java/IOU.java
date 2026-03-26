import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> hashMap = new HashMap<>();

    public void setSum(String toWhom, double amount) {
        hashMap.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
       if (hashMap.containsKey(toWhom)) {
           return hashMap.get(toWhom);
       }
        return 0;
    }
}
