package com.Student.Student_Detail.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStudentRequest {

    private String firstName;
    private String email;
    private String password;
    private String fatherName;
    private String motherName;


}