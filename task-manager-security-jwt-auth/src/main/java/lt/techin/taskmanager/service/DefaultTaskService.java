package lt.techin.taskmanager.service;

import lt.techin.taskmanager.exception.customexception.*;
import lt.techin.taskmanager.model.project.Project;
import lt.techin.taskmanager.model.task.Task;
import lt.techin.taskmanager.model.task.TaskStatus;
import lt.techin.taskmanager.model.user.User;
import lt.techin.taskmanager.repository.ProjectRepository;
import lt.techin.taskmanager.repository.TaskRepository;
import lt.techin.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultTaskService implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public DefaultTaskService(TaskRepository taskRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
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
    public Task create(Long projectId, Task task, Long assigneeId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));

        if (project.getArchived()) {
            throw new ArchivedProjectException(projectId);
        }

        if (assigneeId != null) {
            User user = userRepository.findById(assigneeId)
                    .orElseThrow(() -> new UserNotFoundException(assigneeId));
            task.setAssignee(user);
        }


        task.setProject(project);
        task.setStatus(TaskStatus.TODO);
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task, Long projectId, Long assigneeId) {
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
            if (assigneeId != null) {
                throw new IllegalTaskStateException("Task with id " + id + " is completed and cannot be reassigned.");
            }
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

        if (assigneeId != null) {
            User assignee = userRepository.findById(assigneeId)
                    .orElseThrow(() -> new UserNotFoundException(assigneeId));
            existing.setAssignee(assignee);
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
        taskRepository.deleteById(id);
    }
}
