package first_project.Spring_boot_mark1.Service;

import first_project.Spring_boot_mark1.ErrorHandlers.RelevantException;
import first_project.Spring_boot_mark1.SecurityConfiguration.Config;
import first_project.Spring_boot_mark1.entities.Mentor;
import first_project.Spring_boot_mark1.repository.MentorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MentorService {

    @Autowired
    private MentorRepo mentorRepo;

    @Autowired
    private Config config;

    public BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Mentor addMentor(Mentor mentor) {
        mentor.setPassword(bCryptPasswordEncoder.encode(mentor.getPassword()));
        return this.mentorRepo.save(mentor);
    }

    public void delete(Long mentorId) {
        this.mentorRepo.deleteById(mentorId);
    }

    public Mentor updateMentor(long mentorId,Mentor mentor) {
        Mentor updatedmentor = this.mentorRepo.findById(mentorId).orElseThrow(() -> new RelevantException("Object not found with mentorId: "+mentorId));
        updatedmentor.setName(mentor.getName());
        updatedmentor.setExpertise(mentor.getExpertise());
        updatedmentor.setCoursesList(mentor.getCoursesList());
        updatedmentor.setYearsOfExperience(mentor.getYearsOfExperience());
        return this.mentorRepo.save(updatedmentor);
    }

    public Mentor fetchMentor(long mentorId) {
        return this.mentorRepo.findById(mentorId).orElseThrow(() -> new RelevantException("Object not found with mentorId: "+mentorId));
    }
}
