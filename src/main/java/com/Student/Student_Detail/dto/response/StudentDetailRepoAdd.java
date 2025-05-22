package com.Student.Student_Detail.dto.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetailRepoAdd {
    private String name;
    private String lasnName;
    private Long id;

}
