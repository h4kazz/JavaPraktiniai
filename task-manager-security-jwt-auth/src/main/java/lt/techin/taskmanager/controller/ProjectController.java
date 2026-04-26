package lt.techin.taskmanager.controller;

import jakarta.validation.Valid;
import lt.techin.taskmanager.dto.project.*;
import lt.techin.taskmanager.dto.task.CreateTaskRequest;
import lt.techin.taskmanager.dto.task.TaskMapper;
import lt.techin.taskmanager.dto.task.TaskResponse;
import lt.techin.taskmanager.model.project.Project;
import lt.techin.taskmanager.model.task.Task;
import lt.techin.taskmanager.model.task.TaskStatus;
import lt.techin.taskmanager.service.ProjectService;
import lt.techin.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;
    private final TaskMapper taskMapper;
    private final TaskService taskService;

    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskMapper = new TaskMapper();
        this.projectMapper = new ProjectMapper();
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> create(@Valid @RequestBody CreateProjectRequest request) {
        Project project = projectMapper.toProject(request);
        Project createdProject = projectService.create(project);
        ProjectResponse response = projectMapper.toResponse(createdProject);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<ProjectResponse> getAll() {
        List<Project> projects = projectService.getAll();
        return projectMapper.toResponseList(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getById(@PathVariable Long id) {
        Project project = projectService.getById(id);
        return ResponseEntity.ok(projectMapper.toResponse(project));
    }

    @GetMapping("/{id}/tasks")
    public List<TaskResponse> getTasks(@PathVariable Long id,
                                       @RequestParam(required = false) TaskStatus status) {

        Project project = projectService.getById(id);

        List<Task> tasks = project.getTasks().stream()
                .filter(t -> status == null || t.getStatus() == status)
                .toList();

        return taskMapper.toResponseList(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> update(@PathVariable Long id,
                                                  @Valid @RequestBody UpdateProjectRequest request) {
        Project project = projectMapper.toProject(request, id);
        Project updatedProject = projectService.update(id, project);

        return ResponseEntity.ok(projectMapper.toResponse(updatedProject));
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<ProjectResponse> patch(@PathVariable Long id,
                                                  @Valid @RequestBody PatchProjectRequest request) {
        Project updatedProject = projectService.updateArchived(id, request.archived());

        return ResponseEntity.ok(projectMapper.toResponse(updatedProject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.delete(id);
        return  ResponseEntity.noContent().build();
    }

    @PostMapping("/{projectId}/tasks")
    public ResponseEntity<TaskResponse> createTask(@PathVariable Long projectId,
                                                   @Valid @RequestBody CreateTaskRequest request) {
        Task task = taskMapper.toTask(request);
        Task createdTask = taskService.create(projectId, task, request.assigneeId());
        TaskResponse response = taskMapper.toResponse(createdTask);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
