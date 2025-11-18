package first_project.Spring_boot_mark1.repository;

import first_project.Spring_boot_mark1.entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepo extends JpaRepository<Mentor,Long> {

    Mentor findByEmailId(String emailId);
}
