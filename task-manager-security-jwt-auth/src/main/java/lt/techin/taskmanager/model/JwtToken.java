package lt.techin.taskmanager.model;

import java.time.Instant;

public record JwtToken(
        String value,
        Instant expiresAt
) {
}
