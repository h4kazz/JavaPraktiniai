package decorator;

public class GreeterImp implements Greeter {

    @Override
    public String greet(String firstName, String lastName) {
        return "Labas " + firstName + " " + lastName;
    }
}
