package com.Student.Student_Detail.Controller;

import com.Student.Student_Detail.Entity.StudentClass;
import com.Student.Student_Detail.Entity.StudentDetail;
import com.Student.Student_Detail.Entity.StudentEntity;
import com.Student.Student_Detail.dto.request.*;
import com.Student.Student_Detail.dto.response.StudentDetailRepoAdd;
import com.Student.Student_Detail.dto.response.StudentResponce;
import com.Student.Student_Detail.Service.StudentService;
import com.Student.Student_Detail.dto.response.SuccessMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Studentapi")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //    @PostMapping("/put")
//    public AddStudentRequest puutstudentdetailt(@RequestBody AddStudentRequest addStudentRequest) {
//      return  studentService.putstudentdetail(addStudentRequest);
//
//    }
//    @PostMapping("/get")
//    public List<StudentResponce> getdetail() {
//        return studentService.getstudentdetail();
//    }
//        @PostMapping("/delete")
//    public String delete(@RequestBody StudentRequest studentRequest) {
//        return studentService.deletestudentdetail(studentRequest);
//        }
//
//        @PostMapping("/modify")
//    public String modify(@RequestBody ModifyStudent modifyStudent) {
//        return studentService.modifystudentdetail(modifyStudent);
//        }
//
//        @PostMapping("/look")
//    public StudentResponce look(@RequestBody StudentResponce studentResponce) {
//        return studentService.getstudentdetailById(studentResponce);
//        }
//
    @PostMapping("/insert")
    public String insert(@RequestBody AddStudentRequest addStudentRequest) {
        return studentService.getaddstudentdetail(addStudentRequest);
    }

    @PostMapping("/look")
    public ResponseEntity<?> look() {
        return studentService.getstudentdetail();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody StudentRequest studentRequest) {
        return studentService.Deletebyid(studentRequest);

    }

    @PostMapping("/modify")
    public ResponseEntity<?> modify(@RequestBody ModifyById modifyById) {
        return studentService.modifyStudentDetail(modifyById);
    }

    @PostMapping("/find")
    public ResponseEntity<?> find(@RequestBody StudentResponce studentResponce) {
        return studentService.findbyid(studentResponce);
    }
    @PostMapping("/studentadd")
    public StudentClass studentadd(@RequestBody StudentClass studentClass) {
        return studentService.InsertData(studentClass);
    }
    @PostMapping("/studentFind")
    public StudentDetail findstudent(@RequestBody StudentDetailRepoAdd  studentDetailRepoAdd) {
        return studentService.InsertData3(studentDetailRepoAdd);
    }

}
