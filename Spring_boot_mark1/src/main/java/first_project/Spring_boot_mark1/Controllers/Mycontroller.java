package first_project.Spring_boot_mark1.Controllers;

import first_project.Spring_boot_mark1.Service.StudentService;
import first_project.Spring_boot_mark1.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Mycontroller {
    private final StudentService studentService;
    @Autowired
    public Mycontroller(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return this.studentService.addStudent(student);
    }
//    @GetMapping("/student")
//    public Student getStudent(long studentId){
//        return this.studentService.getStudent(studentId);
//    }
//    @DeleteMapping("/student")
//    public void deleteStudentById(long studentId){
//         this.studentService.deleteStudentById(studentId);
//    }
}
