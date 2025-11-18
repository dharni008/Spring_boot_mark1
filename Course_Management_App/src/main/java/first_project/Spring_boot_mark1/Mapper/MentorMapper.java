package first_project.Spring_boot_mark1.Mapper;

import first_project.Spring_boot_mark1.Dto.MentorDto;
import first_project.Spring_boot_mark1.Dto.RegisterMentorDto;
import first_project.Spring_boot_mark1.ErrorHandlers.RelevantException;
import first_project.Spring_boot_mark1.entities.Courses;
import first_project.Spring_boot_mark1.entities.Mentor;
import first_project.Spring_boot_mark1.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MentorMapper {

    @Autowired
    private CourseRepo courseRepo;

    public Mentor maptoMentor(MentorDto mentorDto){
        Mentor mentor = new Mentor();
        List<Courses> courses = new ArrayList<>();
        for (Long id : mentorDto.getCoursesList()){
            courses.add(this.courseRepo.findById(id).orElseThrow(() -> new RelevantException(" Course not found with id: " +id)));
        }
        mentor.setName(mentorDto.getName());
        mentor.setExpertise(mentorDto.getExpertise());
        mentor.setCoursesList(courses);
        mentor.setYearsOfExperience(mentorDto.getYearsOfExperience());
        return mentor;
    }
    public Mentor mapToRegister(RegisterMentorDto registerMentorDto){
        Mentor mentor = new Mentor();
        mentor.setName(registerMentorDto.getName());
        mentor.setEmailId(registerMentorDto.getEmailId());
        mentor.setPassword(registerMentorDto.getPassword());
        return mentor;
    }
}
