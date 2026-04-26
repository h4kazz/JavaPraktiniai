package lt.techin.taskmanager.dto.user;

public record UpdateUserRequest(
        String name,
        String email
) {
}
