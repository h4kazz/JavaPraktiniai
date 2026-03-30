import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PostStamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhilatelistImpl implements Philatelist {
    private List<PostStamp> stampCollection = new ArrayList<>();

    @Override
    public void addToCollection(PostStamp postStamp) {
        if (postStamp == null || postStamp.getName() == null || postStamp.getName().isEmpty()) {
            throw new IllegalArgumentException("Post stamp is null");
        }

        boolean exists = stampCollection.stream()
                .anyMatch(s -> s == postStamp);

        if (!exists) {
            stampCollection.add(postStamp);
        }
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        return stampCollection.size();
    }

    @Override
    public void printAllPostStampNames() {
        stampCollection.stream()
                .map(PostStamp::getName)
                .forEach(System.out::println);
    }

    @Override
    public void printPostStampsWithPriceGreaterThan(double v) {
        stampCollection.stream()
                .filter(s -> s.getMarketPrice() > v)
                .map(PostStamp::getName)
                .forEach(System.out::println);
    }

    @Override
    public boolean isPostStampInCollection(PostStamp postStamp) {
        return stampCollection.stream()
                .anyMatch(s -> s.equals(postStamp));
    }

    @Override
    public boolean isPostStampWithNameInCollection(String s) {
        return stampCollection.stream()
                .map(PostStamp::getName)
                .anyMatch(st -> st.equals(s));
    }

    @Override
    public double calculateTotalMarketPrice() {
        return stampCollection.stream()
                .mapToDouble(PostStamp::getMarketPrice)
                .sum();
    }

    @Override
    public double getAveragePostStampPrice() {
        return stampCollection.stream()
                .mapToDouble(PostStamp::getMarketPrice)
                .average()
                .orElse(0);
    }

    @Override
    public PostStamp getTheMostExpensivePostStampByMarketValue() {
        return stampCollection.stream()
                .max(Comparator.comparingDouble(PostStamp::getMarketPrice))
                .orElse(null);
    }

    @Override
    public List<PostStamp> findPostStampsByNameContaining(String s) {
        return stampCollection.stream()
                .filter(st -> st.getName().contains(s))
                .toList();
    }

    @Override
    public List<PostStamp> getSortedPostStampsByName() {
        return stampCollection.stream()
                .sorted(Comparator.comparing(PostStamp::getName))
                .toList();
    }
}
