package lt.techin.taskmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IllegalTaskStateException extends RuntimeException {
    public IllegalTaskStateException(Long id) {
        super("Task with id " + id + " is already done.");
    }

    public IllegalTaskStateException(String message) {
        super(message);
    }
}
