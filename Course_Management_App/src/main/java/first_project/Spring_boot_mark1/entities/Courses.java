package first_project.Spring_boot_mark1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Courses {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long coursesId;
    @NotBlank(message = "courseTitle should not be blank")
    @NotNull(message = "courseTitle should not be null")
    private String courseTitle;
    @NotBlank(message = "description should not be blank")
    @NotNull(message = "description should not be null")
    private String description;
    @NotBlank(message = "mentorName should not be blank")
    @NotNull(message = "mentorName should not be null")
    private String MentorName;
    @NotNull(message = "courseHours must not be null")
    @Min(value = 1, message = "courseHours must be more than 1")
    private Long courseHours;
    @NotNull(message = "courseHours must not be null")
    @Positive(message = "price must be in positive")
    private float price;
   // @NotNull(message = "videoName must not be null")
    private String VideoName;
    @Lob
    //@NotNull(message = "video must not be null")
    private byte[] video;
}
