package lt.techin.taskmanager.dto.task;

import lt.techin.taskmanager.dto.user.UserSummaryResponse;
import lt.techin.taskmanager.dto.project.ProjectSummaryResponse;
import lt.techin.taskmanager.model.task.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        LocalDate dueDate,
        LocalDateTime completedAt,
        ProjectSummaryResponse project,
        UserSummaryResponse assignee
) {
}