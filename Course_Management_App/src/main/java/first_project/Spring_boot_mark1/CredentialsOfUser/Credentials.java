package first_project.Spring_boot_mark1.CredentialsOfUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Credentials {
    @Email(message = "EmailId should be valid")
    @NotNull(message = "emailId should not be null")
    @NotBlank(message = "emailId should not be blank")
    private String EmailId;
    @Size(min = 6,message = "password must be over 6 characters")
    @NotNull(message = "password should not be null")
    @NotBlank(message = "password should not be blank")
    private String Password;
}
