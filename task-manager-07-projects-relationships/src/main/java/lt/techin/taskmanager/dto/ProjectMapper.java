package lt.techin.taskmanager.dto;

import lt.techin.taskmanager.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectMapper {

    public Project toProject(CreateProjectRequest request) {
        Project project = new Project();

        project.setName(request.name());
        project.setDescription(request.description());
        project.setArchived(false);

        return project;
    }

    public Project toProject(UpdateProjectRequest request, Long id) {
        Project project = new Project();

        project.setId(id);
        project.setName(request.name());
        project.setDescription(request.description());
        project.setArchived(request.archived());

        return project;
    }

    public ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getArchived()
        );
    }

    public List<ProjectResponse> toResponseList(List<Project> projects) {
        List<ProjectResponse> responses = new ArrayList<>();

        for (Project project : projects) {
            responses.add(toResponse(project));
        }

        return responses;
    }

    public ProjectSummaryResponse toSummaryResponse(Project project) {
        return new ProjectSummaryResponse(
                project.getId(),
                project.getName(),
                project.getArchived()
        );
    }
}
