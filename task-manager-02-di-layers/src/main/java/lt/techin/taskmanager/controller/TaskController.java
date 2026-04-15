package lt.techin.taskmanager.controller;

import lt.techin.taskmanager.exception.TaskNotFoundException;
import lt.techin.taskmanager.model.Task;
import lt.techin.taskmanager.service.TaskService;
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
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/api/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task taskToCreate = taskService.create(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(taskToCreate);
    }

    @GetMapping("/api/tasks")
    public List<Task> getTasks() {
        return taskService.getAll();
    }

    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Task foundTask = taskService.getById(id);

        return ResponseEntity.ok(foundTask);
    }

    @PutMapping("/api/tasks/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.update(id, task);

        return ResponseEntity.ok(updatedTask);
    }

    @PatchMapping("/api/tasks/{id}/done")
    public ResponseEntity<Task> completeTask(@PathVariable Long id, @RequestParam boolean value) {
        Task taskToUpdate = taskService.updateDone(id, value);

        return ResponseEntity.status(HttpStatus.OK).body(taskToUpdate);
    }

    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/tasks/search")
    public List<Task> searchTasksByDone(@RequestParam boolean done) {
        return taskService.searchByDone(done);
    }
}
