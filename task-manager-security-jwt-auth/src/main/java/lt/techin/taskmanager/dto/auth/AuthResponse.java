package lt.techin.taskmanager.dto.auth;

import java.time.Instant;
import java.util.List;

public record AuthResponse(
        String tokenType,
        String accessToken,
        Instant expiresAt,
        String email,
        List<String> roles
) {
}
