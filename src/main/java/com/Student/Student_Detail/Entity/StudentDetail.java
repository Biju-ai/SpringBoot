package com.Student.Student_Detail.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="student_list")

public class StudentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lasnName;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id") // foregin key
    private StudentClass studentClass;
}
