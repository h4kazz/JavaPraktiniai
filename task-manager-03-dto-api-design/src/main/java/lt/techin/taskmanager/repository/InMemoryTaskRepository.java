package lt.techin.taskmanager.repository;

import lt.techin.taskmanager.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryTaskRepository implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    @Override
    public List<Task> findAll() {
        return List.copyOf(tasks);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Task> findByDone(boolean done) {
        return tasks.stream()
                .filter(task -> task.isDone() == done)
                .toList();
    }

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(nextId++);
            tasks.add(task);
            return task;
        }

        Optional<Task> existing = findById(task.getId());
        if (existing.isPresent()) {
            Task current = existing.get();
            current.setTitle(task.getTitle());
            current.setDescription(task.getDescription());
            current.setDone(task.isDone());
            return current;
        }

        tasks.add(task);
        return task;
    }

    @Override
    public void deleteById(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
