package lt.techin.taskmanager.dto.project;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Boolean archived
) {
}
