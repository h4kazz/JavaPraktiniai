package lt.techin.taskmanager.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FieldError {

    private final String field;
    private final String message;
}
