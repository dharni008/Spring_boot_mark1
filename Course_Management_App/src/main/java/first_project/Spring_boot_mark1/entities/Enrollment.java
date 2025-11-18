package first_project.Spring_boot_mark1.entities;

import first_project.Spring_boot_mark1.EnumPackage.CompletionOfCourse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "studentsEnrollmentList")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Enrollmentid;

    @ManyToOne
    @JoinColumn(name = "student_id",unique = true)
    private Student studentId;

    @ManyToMany
    @JoinTable(name = "Enrollment_List",
            joinColumns = @JoinColumn(name = "enrollment_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id",unique = false))
    private List<Courses> coursesId= new ArrayList<>();

    private LocalDate enrollmentDate;

    private CompletionOfCourse statusOfCompletion = CompletionOfCourse.ON_PROCESS;


}
