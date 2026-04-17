package lt.techin.taskmanager.service;

import lt.techin.taskmanager.dto.CreateTaskRequest;
import lt.techin.taskmanager.exception.IllegalTaskStateException;
import lt.techin.taskmanager.exception.TaskNotFoundException;
import lt.techin.taskmanager.model.Task;
import lt.techin.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

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
    public List<Task> searchByDone(boolean done) {
        return taskRepository.findByDone(done);
    }

    @Override
    public Task create(Task task) {
        Task taskToCreate = new Task(null, task.getTitle(), task.getDescription(), false, task.getDueDate());
        return taskRepository.save(taskToCreate);
    }

    @Override
    public Task update(Long id, Task task) {
        Task existing = getById(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setDone(task.isDone());
        existing.setDueDate(task.getDueDate());
        return taskRepository.save(existing);
    }

    @Override
    public Task updateDone(Long id, boolean value) {
        Task existing = getById(id);
        if (existing.isDone() && value) {
            throw new IllegalTaskStateException(id);
        }
        existing.setDone(value);
        return taskRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        taskRepository.deleteById(id);
    }
}
