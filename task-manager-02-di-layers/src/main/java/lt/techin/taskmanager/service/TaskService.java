package lt.techin.taskmanager.service;

import lt.techin.taskmanager.model.Task;
import lt.techin.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {
    List<Task> getAll();

    Task getById(Long id);

    List<Task> searchByDone(boolean done);

    Task create(Task task);

    Task update(Long id, Task task);

    Task updateDone(Long id, boolean done);

    Task delete(Long id);
}
