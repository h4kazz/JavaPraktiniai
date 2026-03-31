package strategy;

public class App {
    public static void main(String[] args) {
        Greeter labas = new Greeter(new LithuanianGreetingStrategy());
        labas.greet("Testas", "Testauskas");

        Greeter hello = new Greeter(() -> "Holla");
        hello.greet("Test", "Test");
    }
}
