package lt.techin.taskmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiError> handleTaskNotFound(TaskNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiError errorToThrow = new ApiError(e.getMessage(), status.getReasonPhrase(), status.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorToThrow);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> new FieldError(fe.getField(), fe.getDefaultMessage()))
                .toList();

        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("Validation failed.", status.getReasonPhrase(), status.value(), fieldErrors));
    }

    @ExceptionHandler(IllegalTaskStateException.class)
    public  ResponseEntity<ApiError> handleIllegalTaskState(IllegalTaskStateException e) {
        HttpStatus status = HttpStatus.CONFLICT;

        ApiError error = new ApiError(e.getMessage(), status.getReasonPhrase(), status.value());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<ApiError> handleProjectNotFound(ProjectNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiError errorToThrow = new ApiError(e.getMessage(), status.getReasonPhrase(), status.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorToThrow);
    }

    @ExceptionHandler(ArchivedProjectException.class)
    public ResponseEntity<ApiError> handleArchivedProject(ArchivedProjectException e) {
        HttpStatus status = HttpStatus.CONFLICT;
        ApiError errorToThrow = new ApiError(e.getMessage(), status.getReasonPhrase(), status.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorToThrow);
    }

    @ExceptionHandler(DuplicateProjectException.class)
    public ResponseEntity<ApiError> handleDuplicateProject(DuplicateProjectException e) {
        HttpStatus status = HttpStatus.CONFLICT;
        ApiError errorToThrow = new ApiError(e.getMessage(), status.getReasonPhrase(), status.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorToThrow);
    }
}
