package lt.techin.taskmanager.exception.customexception;

public class ArchivedProjectException extends RuntimeException {
    public ArchivedProjectException(Long id) {
        super("Project with id " + id + " is archived and cannot accept new tasks.");
    }
}
