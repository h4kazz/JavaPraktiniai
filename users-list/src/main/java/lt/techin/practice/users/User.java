package lt.techin.practice.users;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    private Integer age;

    private boolean male;

    private List<String> hobbies = new ArrayList<>();

    public User(Integer age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, boolean male) {
        this.name = name;
        this.male = male;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, Integer age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public User(String name, Integer age, boolean male, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public static List<User> getUsersWithAge(Integer... ages) {
        List<User> users = new ArrayList<>();
        for (Integer age : ages) {
            users.add(new User(age));
        }
        return users;
    }

}
