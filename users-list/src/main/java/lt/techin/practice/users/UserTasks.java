package lt.techin.practice.users;

import java.util.*;
import java.util.stream.Collectors;

public class UserTasks {

    // Count how many users in the list are older than 25.
    public static Integer countUsersOlderThan25(List<User> users) {
        return (int) users.stream()
                .filter(u -> u.getAge() > 25)
                .count();
    }

    // Calculate and return the average age of all users in the list.
    public static double getAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(u -> u.getAge())
                .average()
                .orElse(0.0);
    }

    // Find and return the smallest age from the list of users.
    public static Integer getMinAge(List<User> users) {
        return users.stream()
                .mapToInt(u -> u.getAge())
                .min()
                .orElse(0);
    }

    // Find the first user whose name matches the provided name.
    public static User findByName(List<User> users, String name) {
       return users.stream()
               .filter(u -> u.getName().equals(name))
               .findFirst()
               .orElseThrow(() -> new RuntimeException("User not found " + name));
    }

    // Return a new list of users sorted by age in ascending order.
    public static List<User> sortByAge(List<User> users) {
        List<User> sorted = new ArrayList<>(users);
        return sorted.stream()
                .sorted(Comparator.comparing(User::getAge))
                .toList();
    }

    // Find and return the oldest user in the list.
    public static User findOldest(List<User> users) {
        return users.stream()
                .max(Comparator.comparing(User::getAge))
                .orElse(null);
    }

    // Sum all user ages and return the result as an int.
    public static int sumAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .sum();
    }

    // Count how many users have the provided hobby in their hobbies collection.
    public static Integer countUsersWithTheHobby(List<User> users, String hobby) {
        return (int) users.stream()
                .filter(u -> u.getHobbies().contains(hobby))
                .count();
    }

    // Find and return all users who have the provided hobby.
    public static List<User> findUsersWithHobby(List<User> users, String hobby) {
        return users.stream()
                .filter(u -> u.getHobbies().contains(hobby))
                .toList();
    }

    // Return all unique hobbies from every user as a set.
    public static Set<String> getUniqueHobbies(List<User> users) {
        return users.stream()
                .flatMap(u -> u.getHobbies().stream())
                .collect(Collectors.toSet());
    }

}
