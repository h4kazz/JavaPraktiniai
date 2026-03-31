package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isOn = false;

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void setOn() {
        this.isOn = true;
    }

    @Override
    public void setOff() {
        this.isOn = false;
    }

    @Override
    public int read() {
        if (!isOn) {
            throw new IllegalStateException("Sensor is off");
        }

        return new Random().nextInt(61) - 30;
    }
}
