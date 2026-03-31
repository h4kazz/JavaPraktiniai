package strategy;

public class Greeter {
    GreeterLanguageStrategy greeterStrategy;

    public Greeter(GreeterLanguageStrategy greeterStrategy) {
        this.greeterStrategy = greeterStrategy;
    }

    public void greet(String firstName, String lastName) {
        System.out.println(greeterStrategy.getGreetingString() + " " + firstName + " " + lastName);
    }
}
