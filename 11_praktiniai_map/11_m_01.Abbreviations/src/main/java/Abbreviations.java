import java.util.HashMap;
import java.util.Map;

public class Abbreviations {
    private Map<String, String> abbreviationMap = new HashMap<>();

    public Abbreviations() {
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviationMap.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        return abbreviationMap.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation) {
        return abbreviationMap.get(abbreviation);
    }
}
