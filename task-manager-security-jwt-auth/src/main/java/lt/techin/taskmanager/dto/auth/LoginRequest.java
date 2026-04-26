package lt.techin.taskmanager.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank
        String email,

        @NotBlank
        @Size(min = 4, message = "Password must contain at least 4 characters")
        String password
) {
}
