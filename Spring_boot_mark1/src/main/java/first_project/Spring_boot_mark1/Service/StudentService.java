package first_project.Spring_boot_mark1.Service;

import first_project.Spring_boot_mark1.entities.Student;
import first_project.Spring_boot_mark1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public Student addStudent(Student student){
        Student addedStudent=this.studentRepository.save(student);
        return addedStudent;
    }
    public Student getStudent(long studentId){
        Optional<Student> id = this.studentRepository.findById(studentId);
        return id.orElse(null);
    }
    public void deleteStudentById(long studentId){
        this.studentRepository.deleteById(studentId);
    }
}
