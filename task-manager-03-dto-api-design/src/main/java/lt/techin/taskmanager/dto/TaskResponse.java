package lt.techin.taskmanager.dto;

public record TaskResponse(
        Long id,
        String title,
        String description,
        boolean done
) {
}