package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors = new ArrayList<>();
    private List<Integer> readings = new ArrayList<>();

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        return sensors.stream()
                .anyMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensors.stream()
                .forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors.stream()
                .forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("Sensors are off or empty");
        }

        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.read();
        }

        int average = sum / sensors.size();
        readings.add(average);
        return average;
    }


    public List<Integer> readings() {
        return new ArrayList<>(readings);
    }
}
