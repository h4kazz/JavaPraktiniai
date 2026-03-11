package lt.techin.praktinis;

public class TemperatureConverter {
    public void toFahrenheit(int temperatureCelsius){
        int farenheit = (temperatureCelsius * 9 / 5) + 32;
        System.out.println(farenheit);
    }
}
