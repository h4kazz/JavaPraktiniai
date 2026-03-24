package lt.techin.practice.users;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Test;

public class UserTasksTest {

    @Test
    public void shouldReturnNumberOfUsersOlderThan25() {
        List<User> users = User.getUsersWithAge(18, 20, 21, 22, 23, 24, 25, 26);
        Integer count = UserTasks.countUsersOlderThan25(users);
        assertTrue(count == 1);
    }

    @Test
    public void shouldFindMinAge() {
        List<User> users = User.getUsersWithAge(10, 20, 30);
        assertThat(UserTasks.getMinAge(users), equalTo(10));

        List<User> users2 = User.getUsersWithAge(40, 20, 30);
        assertThat(UserTasks.getMinAge(users2), equalTo(20));
    }

    @Test
    public void shouldCalculateAverage() {
        List<User> users = User.getUsersWithAge(10, 20, 30);
        assertThat(UserTasks.getAverageAge(users), equalTo((double) (10 + 20 + 30) / 3));
    }

    @Test
    public void shouldFindUserByName() {
        User homer = new User("Homer", true);
        User bart = new User("Bart", true);
        User maggie = new User("Maggie", false);
        User lisa = new User("Lisa", true);
        List<User> users = asList(homer, bart, maggie, lisa);

        User user = UserTasks.findByName(users, "Homer");
        assertThat(user, equalTo(homer));
    }

    @Test
    public void shouldSortByAge() {
        User homer = new User("Homer", 50);
        User bart = new User("Bart", 12);
        User maggie = new User("Maggie", 2);
        User lisa = new User("Lisa", 8);
        List<User> users = asList(homer, bart, maggie, lisa);

        List<User> sorted = UserTasks.sortByAge(users);
        assertThat(sorted, contains(maggie, lisa, bart, homer));
    }

    @Test
    public void shouldFindOldest() {
        User homer = new User("Homer", 50);
        User bart = new User("Bart", 12);
        User maggie = new User("Maggie", 2);
        User lisa = new User("Lisa", 8);
        List<User> users = asList(homer, bart, maggie, lisa);

        User oldest = UserTasks.findOldest(users);
        assertThat(oldest, equalTo(homer));
    }

    @Test
    public void shouldSumAgeAsInt() {
        User homer = new User("Homer", 50);
        User bart = new User("Bart", 12);
        User maggie = new User("Maggie", 2);
        User lisa = new User("Lisa", 8);
        List<User> users = asList(homer, bart, maggie, lisa);

        int sumAge = UserTasks.sumAge(users);
        assertThat(sumAge, equalTo(50 + 12 + 2 + 8));
    }

    @Test
    public void shouldCountUsersWithTheHobby() {
        User homer = new User("Homer", 50, true, asList("Bowling", "Fishing"));
        User bart = new User("Bart", 12, true, asList("Skateboarding", "Fishing"));
        User maggie = new User("Maggie", 2, false, asList("Drawing"));
        User lisa = new User("Lisa", 8, false, asList("Saxophone", "Reading"));
        List<User> users = asList(homer, bart, maggie, lisa);

        Integer count = UserTasks.countUsersWithTheHobby(users, "Fishing");
        assertThat(count, equalTo(2));
    }

    @Test
    public void shouldFindUsersWithHobby() {
        User homer = new User("Homer", 50, true, asList("Bowling", "Fishing"));
        User bart = new User("Bart", 12, true, asList("Skateboarding", "Fishing"));
        User maggie = new User("Maggie", 2, false, asList("Drawing"));
        User lisa = new User("Lisa", 8, false, asList("Saxophone", "Reading"));
        List<User> users = asList(homer, bart, maggie, lisa);

        List<User> usersWithHobby = UserTasks.findUsersWithHobby(users, "Fishing");
        assertThat(usersWithHobby, contains(homer, bart));
    }

    @Test
    public void shouldReturnUniqueHobbies() {
        User homer = new User("Homer", 50, true, asList("Bowling", "Fishing"));
        User bart = new User("Bart", 12, true, asList("Skateboarding", "Fishing"));
        User maggie = new User("Maggie", 2, false, asList("Drawing", "Bowling"));
        User lisa = new User("Lisa", 8, false, asList("Saxophone", "Reading"));
        List<User> users = asList(homer, bart, maggie, lisa);

        Set<String> uniqueHobbies = UserTasks.getUniqueHobbies(users);
        assertThat(uniqueHobbies, containsInAnyOrder(
                "Bowling",
                "Fishing",
                "Skateboarding",
                "Drawing",
                "Saxophone",
                "Reading"));
    }
}
