package first_project.Spring_boot_mark1.Service;

import first_project.Spring_boot_mark1.ErrorHandlers.RelevantException;
import first_project.Spring_boot_mark1.entities.Courses;
import first_project.Spring_boot_mark1.entities.Student;
import first_project.Spring_boot_mark1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private  StudentRepository studentRepository;

    public BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Student addStudent(Student student){
         student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
         student=this.studentRepository.save(student);
        return student;
    }

    public Student getStudent(long studentId){
        Optional<Student> id = this.studentRepository.findById(studentId);
        return id.orElseThrow(()-> new RelevantException("Student not found with this id: "+id));
    }

    public void deleteStudentById(long studentId) {
        this.studentRepository.deleteById(studentId);
    }

    public Student updateStudent(long studentId,Student updatedstudent) {
       Student student = this.studentRepository.findById(studentId).orElseThrow(()-> new RelevantException("Student not found with this id: "+studentId));
       student.setName(updatedstudent.getName());
       student.setGender(updatedstudent.getGender());
       student.setProfession(updatedstudent.getProfession());
     //  student.setEmailId(updatedstudent.getEmailId()); because emailid never updates,if you want to change emailId logout and create a new student with different emailId
       return this.studentRepository.save(student);
    }

//    public List<Courses> getMycourses(Long studentId) {
//        Student student =  this.studentRepository.findById(studentId).orElseThrow(() -> new RelevantException("student not found with this studentid: "+studentId));
//        return student.getCoursesId();
//    }
    /*
    public void deleteStudentById(long studentId){
        this.studentRepository.deleteById(studentId);
    }*/
}
