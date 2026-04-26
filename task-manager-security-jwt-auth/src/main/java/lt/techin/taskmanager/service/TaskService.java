package lt.techin.taskmanager.service;

import lt.techin.taskmanager.model.task.Task;
import lt.techin.taskmanager.model.task.TaskStatus;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    Task getById(Long id);

    List<Task> searchByStatus(TaskStatus status);

    Task create(Long projectId, Task task, Long assigneeId);

    Task update(Long id, Task task, Long projectId, Long assigneId);

    Task updateStatus(Long id, TaskStatus status);

    void delete(Long id);
}
