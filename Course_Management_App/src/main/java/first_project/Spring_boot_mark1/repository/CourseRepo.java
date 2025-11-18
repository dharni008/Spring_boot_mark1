package first_project.Spring_boot_mark1.repository;

import first_project.Spring_boot_mark1.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Courses,Long> {

    @Query(value = "Select * From Courses c Where (course_title) Like Concat('%', :keyword '%') or (description) Like Concat ('%', :keyword, '%') ",nativeQuery = true)
    List<Courses> findBykeyword(@Param("keyword") String keyword);
}
