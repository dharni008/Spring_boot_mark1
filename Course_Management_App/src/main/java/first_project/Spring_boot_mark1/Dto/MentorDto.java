package first_project.Spring_boot_mark1.Dto;

import first_project.Spring_boot_mark1.entities.Courses;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;

@Data
public class MentorDto {
    @NotBlank(message = "name should not be blank")
    @NotNull(message = "name should not be null")
    private String name;
    @NotBlank(message = "expertise should not be blank")
    @NotNull(message = "expertise should not be null")
    private String expertise;
    @NotNull(message = "courseList should not be null")
    @Size(min = 1,message = "alteast one course must be listed")
    @UniqueElements(message = "duplicate coursesList is not allowed")
    private List<Long> coursesList;
    @NotNull(message = "yearsOfExperience should not be null")
    @Min(value = 2,message = "atleast two years of experience must be there")
    private Integer yearsOfExperience;

}
