package lt.techin.taskmanager.service;

import lt.techin.taskmanager.exception.ArchivedProjectException;
import lt.techin.taskmanager.exception.IllegalTaskStateException;
import lt.techin.taskmanager.exception.ProjectNotFoundException;
import lt.techin.taskmanager.exception.TaskNotFoundException;
import lt.techin.taskmanager.model.Project;
import lt.techin.taskmanager.model.Task;
import lt.techin.taskmanager.model.TaskStatus;
import lt.techin.taskmanager.repository.ProjectRepository;
import lt.techin.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultTaskService implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public DefaultTaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
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
    public Task create(Long projectId, Task task) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));

        if (project.getArchived()) {
            throw new ArchivedProjectException(projectId);
        }

        task.setProject(project);
        task.setStatus(TaskStatus.TODO);
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task, Long projectId) {
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

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));

        if (project.getArchived()) {
            throw new ArchivedProjectException(projectId);
        }

        existing.setProject(project);
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
