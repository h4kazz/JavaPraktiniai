package lt.techin.taskmanager.repository;

import lt.techin.taskmanager.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();

    Task findById(Long id);

    List<Task> findByDone(boolean done);

    Task save(Task task);

    Task delete(Long id);

}
