package lt.techin.taskmanager.service;

import lt.techin.taskmanager.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    Task getById(Long id);

    List<Task> searchByDone(boolean done);

    Task create(Task task);

    Task update(Long id, Task task);

    Task updateDone(Long id, boolean value);

    void delete(Long id);
}
