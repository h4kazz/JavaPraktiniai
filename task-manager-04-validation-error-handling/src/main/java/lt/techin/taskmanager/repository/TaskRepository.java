package lt.techin.taskmanager.repository;

import lt.techin.taskmanager.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();

    Optional<Task> findById(Long id);

    List<Task> findByDone(boolean done);

    Task save(Task task);

    void deleteById(Long id);
}
