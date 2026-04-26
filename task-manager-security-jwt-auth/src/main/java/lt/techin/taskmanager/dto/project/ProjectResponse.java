package lt.techin.taskmanager.dto.project;

public record ProjectResponse(
        Long id,
        String name,
        String description,
        Boolean archived
) {
}
