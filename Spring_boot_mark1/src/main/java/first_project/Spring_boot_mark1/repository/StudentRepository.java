package first_project.Spring_boot_mark1.repository;

import first_project.Spring_boot_mark1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long> {

}
