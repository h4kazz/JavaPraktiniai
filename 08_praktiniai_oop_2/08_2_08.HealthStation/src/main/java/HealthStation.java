
public class HealthStation {
    private int weigingCount = 0;

    public int weigh(Person person) {
        weigingCount++;
        return person.getWeight();
    }

    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }

    public int weighings() {
        return weigingCount;
    }

}
