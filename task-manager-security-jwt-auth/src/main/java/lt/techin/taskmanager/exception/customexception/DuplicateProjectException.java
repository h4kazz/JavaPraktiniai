package lt.techin.taskmanager.exception.customexception;

public class DuplicateProjectException extends RuntimeException {
    public DuplicateProjectException(String name) {
        super("Project with name '" + name + "' already exists.");
    }
}
