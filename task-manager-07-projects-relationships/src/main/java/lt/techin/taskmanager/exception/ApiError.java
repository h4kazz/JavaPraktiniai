package lt.techin.taskmanager.exception;

import lombok.Getter;
import lt.techin.taskmanager.exception.FieldError;

import java.util.List;

@Getter
public class ApiError {
    private final String message;
    private final String error;
    private final int status;

    private List<FieldError> fieldErrors;

    public ApiError(String message, String error, int status) {
        this.message = message;
        this.error = error;
        this.status = status;
    }

    public ApiError(String message, String error, int status, List<FieldError> fieldErrors) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.fieldErrors = fieldErrors;
    }


}
