package first_project.Spring_boot_mark1.Dto;

import first_project.Spring_boot_mark1.EnumPackage.CompletionOfCourse;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDto {

    @NotNull(message = "studentId should not be null")
    private Long studentId;

    @NotNull(message = "studentId should not be null")
    @Size(min = 1,message = "coursesId should not be empty")
    @UniqueElements(message = "duplicate coursesId is not allowed")
    private List<Long> coursesId= new ArrayList<>();

    @NotNull(message = "statusOfCompletion should not be null")
    private CompletionOfCourse statusOfCompletion = CompletionOfCourse.ON_PROCESS;



}
