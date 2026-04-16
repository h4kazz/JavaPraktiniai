package lt.techin.taskmanager.dto;

import lt.techin.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {

    public Task toTask(CreateTaskRequest request) {
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDone(false);
        return task;
    }

    public Task toTask(UpdateTaskRequest request, Long id) {
        Task task = new Task();
        task.setId(id);
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDone(request.done());
        return task;
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isDone()
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