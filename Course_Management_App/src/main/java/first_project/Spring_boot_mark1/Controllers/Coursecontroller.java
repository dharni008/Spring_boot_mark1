package first_project.Spring_boot_mark1.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import first_project.Spring_boot_mark1.ErrorHandlers.InputOutputEx;
import first_project.Spring_boot_mark1.Service.CourseService;
import first_project.Spring_boot_mark1.entities.Courses;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class Coursecontroller {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "addCourses",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> addCourse(@RequestPart @Valid Courses courses, @RequestPart @Valid MultipartFile file) throws IOException {
        return new ResponseEntity<>(courseService.addcourse(courses,file),HttpStatus.OK);
    }

    @PutMapping("updateCourses{courseId}")
    public Courses putCourses(@PathVariable long courseId,@RequestBody Courses courses){
       return this.courseService.updateCourses(courseId,courses);
    }

    @GetMapping("search")
    public ResponseEntity<List<Courses>> searchCourses(@RequestParam String keyword){
       return new ResponseEntity<>(this.courseService.searchForcourses(keyword), HttpStatus.FOUND);
    }

    @DeleteMapping("deletebyCourse{variable}")
    public ResponseEntity<?> deleteCourse(@PathVariable(name = "variable") Long courses_id){
        this.courseService.delete(courses_id);
       return ResponseEntity.ok("Object Deleted");
    }
}
