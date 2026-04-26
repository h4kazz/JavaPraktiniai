package lt.techin.taskmanager.dto.project;

import jakarta.validation.constraints.NotNull;

public record PatchProjectRequest(
        @NotNull
        Boolean archived
) {
}