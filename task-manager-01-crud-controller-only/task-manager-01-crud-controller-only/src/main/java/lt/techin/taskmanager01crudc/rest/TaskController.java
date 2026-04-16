package lt.techin.taskmanager01crudc.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController("/api")
public class TaskController {
    private final AtomicLong  counter = new AtomicLong();
    private List<Task> tasks = new ArrayList<>();

    @PostMapping("/api/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task t = new Task(counter.incrementAndGet(), task.getTitle(), task.getDescription());
        t.setDone(task.isDone());
        tasks.add(t);

        return ResponseEntity.status(HttpStatus.CREATED).body(t);
    }

    @GetMapping("/api/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Task foundTask = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findAny()
                .orElse(null);

        if (foundTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(foundTask);
    }

    @PutMapping("/api/tasks/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        Task foundTask = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findAny()
                .orElse(null);

        if (foundTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        foundTask.setTitle(task.getTitle());
        foundTask.setDescription(task.getDescription());
        foundTask.setDone(task.isDone());
        return ResponseEntity.ok(foundTask);
    }

    @PatchMapping("/api/tasks/{id}/done")
    public ResponseEntity<Task> completeTask(@PathVariable Long id, @RequestParam boolean value) {
        Task foundTask = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findAny()
                .orElse(null);

        if (foundTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        foundTask.setDone(value);

        return ResponseEntity.status(HttpStatus.OK).body(foundTask);
    }

    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id) {
        Task foundTask = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findAny()
                .orElse(null);

        if (foundTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        tasks.remove(foundTask);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/tasks/search")
    public List<Task> searchTasksByDone(@RequestParam boolean done) {
        return tasks.stream()
                .filter(task -> task.isDone() == done)
                .toList();
    }
}
