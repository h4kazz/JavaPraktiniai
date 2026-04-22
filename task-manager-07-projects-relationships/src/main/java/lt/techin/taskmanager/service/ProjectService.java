package lt.techin.taskmanager.service;

import lt.techin.taskmanager.model.Project;
import lt.techin.taskmanager.model.Task;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();

    Project getById(Long id);

    Project create(Project project);

    Project update(Long id, Project project);

    Project updateArchived(Long id, boolean status);

    void delete(Long id);

}