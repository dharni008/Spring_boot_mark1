package first_project.Spring_boot_mark1.repository;

import first_project.Spring_boot_mark1.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment,Long> {

}
