package first_project.Spring_boot_mark1.Controllers;

import first_project.Spring_boot_mark1.CredentialsOfUser.Credentials;
import first_project.Spring_boot_mark1.Dto.MentorDto;
import first_project.Spring_boot_mark1.Dto.RegisterMentorDto;
import first_project.Spring_boot_mark1.ErrorHandlers.RelevantException;
import first_project.Spring_boot_mark1.Mapper.MentorMapper;
import first_project.Spring_boot_mark1.Service.MentorService;
import first_project.Spring_boot_mark1.Utils.Jwtutil;
import first_project.Spring_boot_mark1.entities.Mentor;
import first_project.Spring_boot_mark1.entities.Student;
import first_project.Spring_boot_mark1.repository.MentorRepo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @Autowired
    private MentorMapper mentorMapper;

    @Autowired
    private MentorRepo mentorRepo;

    @Autowired
    private Jwtutil jwtutil;

    @PostMapping("RegisterMentor")
    public ResponseEntity<?> registerMentor(@RequestBody @Valid RegisterMentorDto registerMentorDto){
        Mentor mentor = this.mentorMapper.mapToRegister(registerMentorDto);
        return new ResponseEntity<>("Registered Successfully  "+this.mentorService.addMentor(mentor),HttpStatus.CREATED);
    }

    @PostMapping("LoginMentor")
    public ResponseEntity<?> LoginMentor(@RequestBody @Valid Credentials credentials){
        Mentor mentor = this.mentorRepo.findByEmailId(credentials.getEmailId());
        if(mentor==null){
            throw new RelevantException("No Mentor Found with this EmailId : "+mentor.getEmailId());
        }
        String token = jwtutil.GenerateToken(mentor.getEmailId());
        return new ResponseEntity<>("Mentor LoggedIn and Token : "+token, HttpStatus.FOUND);
    }
//    @PostMapping("Mentor")
//    public ResponseEntity<?> PostMentor(@RequestBody @Valid MentorDto mentorDto){
//        Mentor mentor = this.mentorMapper.maptoMentor(mentorDto);
//        return new ResponseEntity<>(this.mentorService.addMentor(mentor),HttpStatus.OK);
//    }

    @GetMapping("getMentor{mentorId}")
    public Mentor getMentor(@PathVariable @Positive long mentorId){
        return this.mentorService.fetchMentor(mentorId);
    }

    @PutMapping("updateMentor{mentorId}")
    public Mentor updateProfile(@PathVariable @Positive long mentorId,@RequestBody @Valid MentorDto mentorDto){
        Mentor mentor = this.mentorMapper.maptoMentor(mentorDto);
        mentor = this.mentorService.updateMentor(mentorId,mentor);
        return mentor;
    }

    @DeleteMapping("deletebyMentor{variable}")
    public ResponseEntity<?> deleteMentor(@PathVariable(name = "variable") @Positive Long mentor_id){
        this.mentorService.delete(mentor_id);
        return ResponseEntity.ok("Object Deleted");
    }
}
