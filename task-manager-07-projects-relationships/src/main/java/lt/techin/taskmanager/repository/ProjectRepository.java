package lt.techin.taskmanager.repository;

import lt.techin.taskmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByName(String name);
}
