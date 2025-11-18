package first_project.Spring_boot_mark1.Mapper;

import first_project.Spring_boot_mark1.Dto.EnrollmentDto;
import first_project.Spring_boot_mark1.ErrorHandlers.RelevantException;
import first_project.Spring_boot_mark1.entities.Courses;
import first_project.Spring_boot_mark1.entities.Enrollment;
import first_project.Spring_boot_mark1.entities.Student;
import first_project.Spring_boot_mark1.repository.CourseRepo;
import first_project.Spring_boot_mark1.repository.EnrollmentRepo;
import first_project.Spring_boot_mark1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class EnrollmentMapper {

    @Autowired
    private EnrollmentRepo enrollmentRepo;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepo courseRepo;

    public Enrollment maptoEnrollment(EnrollmentDto enrollmentDto){
        Enrollment enrollment = new Enrollment();
        Courses course = new Courses();
        Student student = new Student();
        student = this.studentRepository.findById(enrollmentDto.getStudentId()).orElseThrow(() -> new RelevantException("Object not found with studentId: "+enrollmentDto.getStudentId()));
        enrollment.setStudentId(student);
        List<Courses> coursesList = new ArrayList<>();
        for(long id : enrollmentDto.getCoursesId()){
            course =this.courseRepo.findById(id).orElseThrow(() -> new RelevantException("Object not found with id: " +id));
            coursesList.add(course);
        }
        enrollment.setCoursesId(coursesList);
        enrollment.setEnrollmentDate(LocalDate.now());
        enrollment.setStatusOfCompletion(enrollmentDto.getStatusOfCompletion());
        return enrollment;
    }
}
