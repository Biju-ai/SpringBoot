package com.Student.Student_Detail.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "studentDBS")

public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    private String firstName;
    private String email;
    private String password;
    private String fatherName;
    private String motherName;
}
