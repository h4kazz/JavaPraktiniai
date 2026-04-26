package lt.techin.taskmanager.model.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lt.techin.taskmanager.model.task.Task;

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

//    public void addTask(Task task) {
//        tasks.add(task);
//    }

    public boolean getArchived() {
        return archived;
    }
}