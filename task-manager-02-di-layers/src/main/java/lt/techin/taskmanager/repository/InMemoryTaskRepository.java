package lt.techin.taskmanager.repository;

import lt.techin.taskmanager.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTaskRepository implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Task findById(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Task> findByDone(boolean done) {
        return tasks.stream()
                .filter(task -> task.isDone() == done)
                .toList();
    }

    @Override
    public Task save(Task task) {
        task.setId(counter.incrementAndGet());
        tasks.add(task);
        return task;
    }

    @Override
    public Task delete(Long id) {
        Task taskToDelete = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .get();

        tasks.remove(taskToDelete);
        return taskToDelete;
    }

}
