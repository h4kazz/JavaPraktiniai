package employee;

public class App {
    public static void main(String[] args) {

        Employee manager = new Employee(1, "Testas", "Testauskas", 1500);

        System.out.println(manager.getId());
        System.out.println(manager.getFirstName());
        System.out.println(manager.getLastName());
        System.out.println(manager.getName());
        System.out.println(manager.getSalary());
        manager.setSalary(1700);
        System.out.println(manager.getSalary());
        System.out.println(manager.getAnnualSalary());
        manager.raiseSalary(3);
        System.out.println(manager.getSalary());
        System.out.println(manager.toString());
    }
}