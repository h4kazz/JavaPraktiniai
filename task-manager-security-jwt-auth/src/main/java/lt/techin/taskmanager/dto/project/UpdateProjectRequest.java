package lt.techin.taskmanager.dto.project;

import jakarta.validation.constraints.NotNull;

public record UpdateProjectRequest(
        String name,
        String description,

        @NotNull
        Boolean archived
) {
}
