package first_project.Spring_boot_mark1.Service;

import first_project.Spring_boot_mark1.ErrorHandlers.RelevantException;
import first_project.Spring_boot_mark1.entities.Courses;
import first_project.Spring_boot_mark1.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public Courses addcourse(Courses courses, MultipartFile file) throws IOException {
        courses.setVideoName(file.getOriginalFilename());
        courses.setVideo(file.getBytes());
       courses= courseRepo.save(courses);
       return courses;
    }

    public void delete(Long coursesId) {
        courseRepo.deleteById(coursesId);
    }

    public Courses updateCourses(long courseId, Courses updatedcourses) {
        Courses courses = this.courseRepo.findById(courseId).orElseThrow(()-> new RelevantException("Student not found with this id: "+courseId));
        courses.setCourseTitle(updatedcourses.getCourseTitle());
        courses.setCourseHours(updatedcourses.getCourseHours());
        courses.setPrice(updatedcourses.getPrice());
        courses.setMentorName(updatedcourses.getMentorName());
        courses.setDescription(updatedcourses.getDescription());
        this.courseRepo.save(courses);
        return courses;
    }

    public List<Courses> searchForcourses(String keyword) {
       return this.courseRepo.findBykeyword(keyword);
    }
}
