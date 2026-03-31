package decorator;

public class App {
    public static void main(String[] args) {
        Greeter greeter = new GreeterImp();
        System.out.println(greeter.greet("Testas", "Testauskas"));

        greeter = new GreeterExclamationMarkDecorator(greeter);
        System.out.println(greeter.greet("Testas", "Testauskas"));

        greeter = new GreeterUpperCaseDecorator(greeter);
        System.out.println(greeter.greet("Testas", "Testauskas"));
    }
}
