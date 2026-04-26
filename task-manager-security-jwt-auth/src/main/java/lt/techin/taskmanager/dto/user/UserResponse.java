package lt.techin.taskmanager.dto.user;

public record UserResponse(
        Long id,
        String name,
        String email,
        java.util.Set<lt.techin.taskmanager.model.user.Role> roles) {
}
