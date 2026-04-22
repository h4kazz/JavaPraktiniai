package lt.techin.taskmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean archived;

    @OneToMany(mappedBy = "project")
    List<Task> tasks;

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean getArchived() {
        return archived;
    }
}