package first_project.Spring_boot_mark1.Controllers;

import first_project.Spring_boot_mark1.Dto.EnrollmentDto;
import first_project.Spring_boot_mark1.Mapper.EnrollmentMapper;
import first_project.Spring_boot_mark1.Service.EnrollmentService;
import first_project.Spring_boot_mark1.entities.Enrollment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @PostMapping("addEnrollment")
    public ResponseEntity<Enrollment> postEnrollment(@RequestBody @Valid EnrollmentDto enrollmentDto){
        Enrollment enrollment = this.enrollmentMapper.maptoEnrollment(enrollmentDto);
        enrollment = this.enrollmentService.addEnrollment(enrollment);
        return new ResponseEntity<>(enrollment, HttpStatus.OK);
    }

    @GetMapping("MyEnrolledCourses{enrollment_Id}")
    public Enrollment myLearnings(@PathVariable @Positive Long enrollment_Id){
            return this.enrollmentService.getMycourses(enrollment_Id);
    }

    @PutMapping("UpdateEnrollment{enrollment_Id}")
    public ResponseEntity<?> updateCoursesInEnrollment(@PathVariable @Positive Long enrollment_Id,@RequestBody EnrollmentDto enrollmentDto){
       Enrollment enrollment = this.enrollmentMapper.maptoEnrollment(enrollmentDto);
        return new ResponseEntity<>(this.enrollmentService.updateEnrollment(enrollment_Id,enrollment),HttpStatus.OK);
    }

    @DeleteMapping("deleteByEnrollment{enrollmentId}")
    public ResponseEntity<?> deleteEnrollment(@PathVariable @Positive long enrollmentId){
        this.enrollmentService.deleteBy(enrollmentId);
        return new ResponseEntity<>("Object Deleted",HttpStatus.OK);
    }
}
