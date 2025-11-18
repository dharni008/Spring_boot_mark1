package first_project.Spring_boot_mark1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String expertise;
    @ManyToMany
    @JoinTable(name = "mentor_courses_list",
    joinColumns = @JoinColumn(name ="mentor_id"),
    inverseJoinColumns = @JoinColumn(name = "coursesId",unique = false))
    private List<Courses> coursesList = new ArrayList<>();
    private Integer yearsOfExperience;
    @Column(unique = true)
    private String emailId;
    private String Password;
}
