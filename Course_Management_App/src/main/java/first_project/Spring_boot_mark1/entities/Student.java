package first_project.Spring_boot_mark1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private long studentId;
    @NotBlank(message = "name should not be blank")
    @NotNull(message = "name should not be null")
    private String name;
    @NotBlank(message = "gender should not be blank")
    @NotNull(message = "gender should not be null")
    private String gender;
    @Email(message = "email must be valid")
    @NotNull(message = "emailId should not be null")
    @NotBlank(message = "emailId should not be blank")
    @Column(unique = true)
    private String emailId;
    @Size(min = 6,message = "password must be over 6 characters")
    @NotBlank(message = "password should not be blank")
    @NotNull(message = "password should not be null")
    private String password;
    @NotBlank(message = "profession should not be blank")
    @NotNull(message = "profession should not be null")
    private String profession;

//    @OneToMany(mappedBy = "studentId", cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JsonIgnore
//    private List<Enrollment> enrollmentId;
}
