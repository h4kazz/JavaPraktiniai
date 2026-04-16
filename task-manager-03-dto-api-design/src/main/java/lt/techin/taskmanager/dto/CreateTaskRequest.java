package lt.techin.taskmanager.dto;

public record CreateTaskRequest(
        String title,
        String description
) {
}