package first_project.Spring_boot_mark1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Getter
//@Setter
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="studentId",nullable=false)
    private long studentId;
    @Column(name="studentFirstName",nullable=false)
    private String studentFirstName;
    @Column(name="studentLastName",nullable=false)
    private String studentLastName;
}
