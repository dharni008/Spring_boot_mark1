package first_project.Spring_boot_mark1.Service;

import first_project.Spring_boot_mark1.ErrorHandlers.RelevantException;
import first_project.Spring_boot_mark1.entities.Enrollment;
import first_project.Spring_boot_mark1.repository.EnrollmentRepo;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepo enrollmentRepo;

    public Enrollment addEnrollment(Enrollment enrollment) {
        return this.enrollmentRepo.save(enrollment);
    }

    public void deleteBy(long enrollmentId){
        this.enrollmentRepo.deleteById(enrollmentId);
    }

    public Enrollment getMycourses(Long enrollmentId) {
        Enrollment enrollment =  this.enrollmentRepo.findById(enrollmentId).orElseThrow(() -> new RelevantException("Object not found with enrollmentId: "+enrollmentId));
        return enrollment;
    }

    public Enrollment updateEnrollment(@Positive Long enrollmentId, Enrollment enrollment) {
        Enrollment enrollment1 = this.enrollmentRepo.findById(enrollmentId).orElseThrow(() -> new RelevantException("Object not found with enrollmentId: "+enrollmentId));
        enrollment1.setCoursesId(enrollment.getCoursesId());
        enrollmentRepo.save(enrollment1);
        return enrollment1;
    }
}
