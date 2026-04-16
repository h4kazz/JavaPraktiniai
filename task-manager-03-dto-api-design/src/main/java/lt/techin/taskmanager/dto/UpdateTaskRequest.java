package lt.techin.taskmanager.dto;

public record UpdateTaskRequest(
        String title,
        String description,
        boolean done
) {
}