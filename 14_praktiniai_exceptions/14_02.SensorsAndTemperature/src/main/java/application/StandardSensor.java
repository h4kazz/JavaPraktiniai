package application;

public class StandardSensor implements Sensor {
    private final boolean isOn = true;
    private final int number;

    public StandardSensor(int number) {
        this.number = number;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void setOn() {

    }

    @Override
    public void setOff() {

    }

    @Override
    public int read() {
        return this.number;
    }
}
