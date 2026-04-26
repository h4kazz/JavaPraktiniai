package lt.techin.taskmanager.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank
        @Size(min = 4, max = 100, message = "Name must contain 4 to 100 characters")
        String name,

        @NotBlank
        @Size(min = 3, max = 50, message = "Username must contain 3 to 50 characters")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 4, max = 100, message = "Password must contain 4 to 100 characters")
        String password
) {
}
