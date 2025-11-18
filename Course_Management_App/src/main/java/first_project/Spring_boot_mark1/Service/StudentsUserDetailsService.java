package first_project.Spring_boot_mark1.Service;

import first_project.Spring_boot_mark1.entities.Student;
import first_project.Spring_boot_mark1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentsUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId){
        try {
            Student student = this.studentRepository.findByemailId(emailId);
            return new StudentsUserDetails(student);
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
        }
        return new StudentsUserDetails(new Student());
    }
}
