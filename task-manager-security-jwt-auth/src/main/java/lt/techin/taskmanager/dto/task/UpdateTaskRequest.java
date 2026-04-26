package lt.techin.taskmanager.dto.task;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lt.techin.taskmanager.model.task.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(

        @NotBlank
        @Size(min = 3, max = 100)
        String title,

        @Size(max = 1000)
        String description,

        @NotNull
        TaskStatus status,

        @NotNull
        @FutureOrPresent
        LocalDate dueDate,

        @NotNull
        Long projectId,

        Long assigneeId
) {
}