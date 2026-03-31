package templatemethod;

public class App {
    public static void main(String[] args) {
        Greeter lithuanian = new LithuanianGreeter();
        lithuanian.greet("Testas", "Testauskas");

        Greeter english = new EnglishGreeter();
        english.greet("Test", "Test");
    }
}
