package lt.techin.taskmanager.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateProjectRequest(
        String name,
        String description,

        @NotNull
        Boolean archived
) {
}
