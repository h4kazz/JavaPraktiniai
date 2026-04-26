package lt.techin.taskmanager.service;

import lt.techin.taskmanager.exception.customexception.DuplicateProjectException;
import lt.techin.taskmanager.exception.customexception.ProjectNotFoundException;
import lt.techin.taskmanager.model.project.Project;
import lt.techin.taskmanager.repository.ProjectRepository;
import lt.techin.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProjectService implements ProjectService {
    private final ProjectRepository projectRepository;

    public DefaultProjectService(ProjectRepository projectRepository, TaskRepository taskRepository, TaskService taskService) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @Override
    public Project create(Project project) {

        if (projectRepository.existsByName(project.getName())) {
            throw new DuplicateProjectException(project.getName());
        }

        Project projectToCreate = new Project();

        projectToCreate.setName(project.getName());
        projectToCreate.setDescription(project.getDescription());
        projectToCreate.setArchived(false);
        projectToCreate.setTasks(project.getTasks());

        return projectRepository.save(projectToCreate);
    }

    @Override
    public Project update(Long id, Project project) {
        Project existingProject = new Project();

        existingProject.setName(project.getName());
        existingProject.setDescription(project.getDescription());
        existingProject.setArchived(project.getArchived());

        return projectRepository.save(existingProject);
    }

    @Override
    public Project updateArchived(Long id, boolean value) {
        Project projectToUpdate = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        projectToUpdate.setArchived(value);

        return projectRepository.save(projectToUpdate);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
