package first_project.Spring_boot_mark1.Controllers;

import first_project.Spring_boot_mark1.CredentialsOfUser.Credentials;
import first_project.Spring_boot_mark1.Service.StudentService;
import first_project.Spring_boot_mark1.Utils.Jwtutil;
import first_project.Spring_boot_mark1.entities.Courses;
import first_project.Spring_boot_mark1.entities.Student;
import first_project.Spring_boot_mark1.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Mycontroller {
    @Autowired
    private StudentService studentService;

    @Autowired
    private Jwtutil jwtutil;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("register")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student){
         student=studentService.addStudent(student);
         return  new ResponseEntity<>("Registered Successfully "+student,HttpStatus.CREATED);
    }

    @PostMapping("Login")
    public ResponseEntity<?> login(@RequestBody @Valid Credentials credentials){
       Student student = studentRepository.findByemailId(credentials.getEmailId());
       if(student == null){
           return new ResponseEntity<>("No user found with EmailId "+credentials.getEmailId(),HttpStatus.NOT_FOUND);
       }
        String token = jwtutil.GenerateToken(credentials.getEmailId());
        return new ResponseEntity<>("Student LogeedIn and Token : "+token,HttpStatus.OK);
    }

    @GetMapping("getdetails{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable @Positive long studentId){
        return new ResponseEntity<>(this.studentService.getStudent(studentId),HttpStatus.OK);

    }

//    @GetMapping("/getCsrfToken")
//    public CsrfToken getCsrfToken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }

    @PutMapping("updateStudent{studentId}")
    public Student putStudent(@PathVariable @Positive long studentId, @RequestBody @Valid Student student){
        student = this.studentService.updateStudent(studentId,student);
        return student;
    }
//    @GetMapping("Mycourses{student_id}")
//    public List<Courses> myLearnings(@PathVariable Long student_id){
//        List<Courses> mycourses = this.studentService.getMycourses(student_id);
//        return mycourses;
//    }
    @DeleteMapping("deletebyStudent{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable(name = "id" ) @Positive long studentId){
          this.studentService.deleteStudentById(studentId);
          return new ResponseEntity<>("Object deleted",HttpStatus.OK);
    }
}
