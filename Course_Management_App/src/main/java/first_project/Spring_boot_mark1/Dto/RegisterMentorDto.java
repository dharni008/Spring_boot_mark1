package first_project.Spring_boot_mark1.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMentorDto {
    @NotBlank(message = "name should not be blank")
    @NotNull(message = "name should not be null")
    private String name;
    @Email(message = "email must be valid")
    @NotBlank(message = "emailId should not be blank")
    @NotNull(message = "emailId should not be null")
    private String emailId;
    @Size(min = 6,message = "password must be over 6 characters")
    @NotBlank(message = "password should not be blank")
    @NotNull(message = "password should not be null")
    private String Password;
}
