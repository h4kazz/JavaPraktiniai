public class Counter {
    private int number;

    public Counter(int startValue) {
        this.number = startValue;
    }

    public Counter() {
        this.number = 0;
    }

    public int value() {
        return number;
    }

    public void increase() {
        number++;
    }

    public void decrease() {
        number--;
    }

    public void increase(int increaseBy) {
        if (increaseBy > 0) {
            number += increaseBy;
        }
    }

    public void decrease(int decreaseBy) {
        if (decreaseBy > 0) {
            number -= decreaseBy;
        }
    }
}
