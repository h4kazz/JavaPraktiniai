package lt.techin.taskmanager.service;

import lt.techin.taskmanager.dto.CreateTaskRequest;
import lt.techin.taskmanager.exception.IllegalTaskStateException;
import lt.techin.taskmanager.exception.TaskNotFoundException;
import lt.techin.taskmanager.model.Task;
import lt.techin.taskmanager.model.TaskStatus;
import lt.techin.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultTaskService implements TaskService {
    private final TaskRepository taskRepository;

    public DefaultTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public List<Task> searchByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public Task create(Task task) {
        Task taskToCreate = new Task(null, task.getTitle(), task.getDescription(), task.getDueDate());
        return taskRepository.save(taskToCreate);
    }

    @Override
    public Task update(Long id, Task task) {
        Task existing = getById(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setDueDate(task.getDueDate());

        TaskStatus newStatus = task.getStatus();
        TaskStatus currentStatus = existing.getStatus();

        if (currentStatus == TaskStatus.DONE && newStatus == TaskStatus.TODO) {
            throw new IllegalTaskStateException("Task with id " + id + " cannot move from DONE back to TODO.");
        }

        if (currentStatus == TaskStatus.DONE && newStatus == TaskStatus.DONE) {
            throw new IllegalTaskStateException("Task with id " + id + " is already done.");
        }
        if (newStatus == TaskStatus.DONE) {
            existing.setStatus(TaskStatus.DONE);
            existing.setCompletedAt(LocalDateTime.now());
        }
        return taskRepository.save(existing);
    }

    @Override
    public Task updateStatus(Long id, TaskStatus status) {
        Task existing = getById(id);
        if (existing.getStatus().equals(TaskStatus.DONE)) {
            throw new IllegalTaskStateException(id);
        }

        existing.setStatus(status);
        if (status == TaskStatus.DONE) {
            existing.setCompletedAt(LocalDateTime.now());
        }

        return taskRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        taskRepository.deleteById(id);
    }
}
