package com.Student.Student_Detail.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ModifyById {
    private Long id;
    private String firstName;
    private String email;
    private String fatherName;
    private String motherName;
}

