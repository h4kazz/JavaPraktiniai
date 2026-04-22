package lt.techin.taskmanager.dto;

import lt.techin.taskmanager.model.Task;
import lt.techin.taskmanager.model.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    private ProjectMapper projectMapper = new ProjectMapper();


    public Task toTask(CreateTaskRequest request) {
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(TaskStatus.TODO);
        task.setDueDate(request.dueDate());
        task.setCompletedAt(null);
        return task;
    }

    public Task toTask(UpdateTaskRequest request, Long id) {
        Task task = new Task();
        task.setId(id);
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status());
        task.setDueDate(request.dueDate());
        return task;
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate(),
                task.getCompletedAt(),
                projectMapper.toSummaryResponse(task.getProject())
        );
    }

    public List<TaskResponse> toResponseList(List<Task> tasks) {
        List<TaskResponse> responses = new ArrayList<>();
        for (Task task : tasks) {
            responses.add(toResponse(task));
        }
        return responses;
    }
}