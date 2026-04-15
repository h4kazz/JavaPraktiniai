package lt.techin.taskmanager.service;

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
        if (taskRepository.findById(id) == null) {
            throw new TaskNotFoundException(id);
        }
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> searchByDone(boolean done) {
        return taskRepository.findByDone(done);
    }

    @Override
    public Task create(Task task) {
        task.setDone(false);
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task) {
        Task existingTask = taskRepository.findById(id);

        if (existingTask == null) {
            throw new TaskNotFoundException(id);
        }

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDone(task.isDone());
        return existingTask;
    }

    @Override
    public Task updateDone(Long id, boolean done) {
        if (taskRepository.findById(id) == null) {
            throw new TaskNotFoundException(id);
        }
       Task taskToDone = taskRepository.findById(id);
        taskToDone.setDone(done);
        return taskToDone;
    }

    @Override
    public Task delete(Long id) {
        if (taskRepository.findById(id) == null) {
            throw new TaskNotFoundException(id);
        }
        return taskRepository.delete(id);
    }
}
