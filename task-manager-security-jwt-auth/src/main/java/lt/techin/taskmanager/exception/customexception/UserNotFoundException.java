package lt.techin.taskmanager.exception.customexception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with id " + id + " was not found.");
    }
}
