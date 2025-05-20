package com.Student.Student_Detail.Service;

import com.Student.Student_Detail.dto.request.AddStudentRequest;
import com.Student.Student_Detail.dto.request.ModifyById;
import com.Student.Student_Detail.dto.request.StudentRequest;
import com.Student.Student_Detail.dto.response.StudentResponce;
import com.Student.Student_Detail.Entity.StudentEntity;
import com.Student.Student_Detail.Repositaty.StudentRepository;
import com.Student.Student_Detail.dto.response.SuccessMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    public AddStudentRequest putstudentdetail(AddStudentRequest addStudentRequest) {
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setFirstName(addStudentRequest.getFirstName());
//        studentEntity.setEmail(addStudentRequest.getEmail());
//        studentEntity.setPassword(addStudentRequest.getPassword());
//        studentEntity.setFatherName(addStudentRequest.getFatherName());
//        studentEntity.setMotherName(addStudentRequest.getMotherName());
//        studentRepository.save(studentEntity);
//        return addStudentRequest;
//
//    }

//    public String deletestudentdetail(StudentRequest studentRequest) {
//        Long id = studentRequest.getId();
//        if (studentRepository.existsById(id)) {
//            studentRepository.deleteById(id);
//            return "Deleted";
//        }
//        return "Not Found";
//    }
//
//    public List<StudentResponce> getstudentdetail() {
//        List<StudentEntity> all = studentRepository.findAll();
//        List<StudentResponce> studentResponceList = new ArrayList<>();
//        for (StudentEntity studentEntity : all) {
//            StudentResponce studentResponce = new StudentResponce();
//            studentResponce.setId(studentEntity.getId());
//            studentResponce.setFirstName(studentEntity.getFirstName());
//            studentResponce.setEmail(studentEntity.getEmail());
//            studentResponce.setFatherName(studentEntity.getFatherName());
//            studentResponce.setMotherName(studentEntity.getMotherName());
//            studentResponceList.add(studentResponce);
//        }
//        return studentResponceList;
//    }
//
//    public String modifystudentdetail(ModifyStudent modifyStudentRequest) {
//        String name = modifyStudentRequest.getFirstName();
//
//        StudentEntity studentEntity = studentRepository.findByFirstName(name);
//        if (studentEntity != null) {
//            studentEntity.setFirstName(name);
//            studentEntity.setEmail(studentEntity.getEmail());
//            studentEntity.setPassword(studentEntity.getPassword());
//            studentEntity.setFatherName(studentEntity.getFatherName());
//            studentEntity.setMotherName(studentEntity.getMotherName());
//            studentRepository.save(studentEntity);
//            return "Modified";
//        } else {
//            return "Not Found";
//        }
//    }


    public StudentResponce getstudentdetailById(StudentResponce studentResponce) {
        Long id = studentResponce.getId();
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        List<StudentResponce> studentResponceList = new ArrayList<>();
        StudentResponce studentResponce1 = null;
        if (studentEntity.isPresent()) {
            StudentEntity studentEntity1 = studentEntity.get();
            studentResponce1 = new StudentResponce();
            studentResponce1.setId(studentEntity.get().getId());
            studentResponce1.setFirstName(studentEntity.get().getFirstName());
            studentResponce1.setEmail(studentEntity.get().getEmail());
            studentResponce1.setFatherName(studentEntity.get().getFatherName());
            studentResponce1.setMotherName(studentEntity.get().getMotherName());
            studentResponceList.add(studentResponce1);
        }
        return studentResponce1;

    }

    public String getaddstudentdetail(AddStudentRequest addStudentRequest) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(addStudentRequest.getFirstName());
        studentEntity.setEmail(addStudentRequest.getEmail());
        studentEntity.setPassword(addStudentRequest.getPassword());
        studentEntity.setFatherName(addStudentRequest.getFatherName());
        studentEntity.setMotherName(addStudentRequest.getMotherName());
        studentRepository.save(studentEntity);
        return "data has added successfully";
    }

    public List<StudentResponce> getstudentdetail() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentResponce> studentResponceList = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntityList) {
            StudentResponce studentResponce1 = new StudentResponce();
            studentResponce1.setId(studentEntity.getId());
            studentResponce1.setFirstName(studentEntity.getFirstName());
            studentResponce1.setEmail(studentEntity.getEmail());
            studentResponce1.setFatherName(studentEntity.getFatherName());
            studentResponce1.setMotherName(studentEntity.getMotherName());
            studentResponceList.add(studentResponce1);
        }
        return studentResponceList;
    }

    public String Deletebyid(StudentRequest studentRequest) {
        Long id = studentRequest.getId();
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            studentRepository.deleteById(id);
            return "data has been deleted successfully";
        }
        return "the id you have been given is not identified";
    }

    public SuccessMessage modifyStudentDetail(ModifyById modifyById) {
        Long id = modifyById.getId();
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);

        if (studentEntityOptional.isPresent()) {

            StudentEntity studentEntity = studentEntityOptional.get();

            //update fields

            studentEntity.setFirstName(modifyById.getFirstName());
            studentEntity.setEmail(modifyById.getEmail());
            studentEntity.setFatherName(modifyById.getFatherName());
            studentEntity.setMotherName(modifyById.getMotherName());

            StudentEntity student = studentRepository.save(studentEntity);

            if (student != null) {
                SuccessMessage studentResponce1 = new SuccessMessage();
                studentResponce1.setCode("0");
                studentResponce1.setStatus("OK");
                studentResponce1.setMessage("Successfully updated student detail");
                return studentResponce1;
            } else {
                SuccessMessage wrongResponse = new SuccessMessage();
                wrongResponse.setMessage("Unable to modify student detail");
                return wrongResponse;

            }

        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }


    public List<StudentResponce> findbyid(StudentResponce studentResponce) {
        Long id = studentResponce.getId();
        List<StudentResponce> studentResponceList = new ArrayList<>();
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studentResponce.getId());
        if (studentEntityOptional.isPresent()) {
            StudentResponce studentResponce1 = new StudentResponce();
            studentResponce1.setId(studentEntityOptional.get().getId());
            studentResponce1.setFirstName(studentEntityOptional.get().getFirstName());
            studentResponce1.setEmail(studentEntityOptional.get().getEmail());
            studentResponce1.setFatherName(studentEntityOptional.get().getFatherName());
            studentResponce1.setMotherName(studentEntityOptional.get().getMotherName());

            studentResponceList.add(studentResponce1);
        }
        return studentResponceList;
    }

    public SuccessMessage modifybyid(ModifyById modifyById) {
        Long id = modifyById.getId();
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        if (studentEntityOptional.isPresent()) {
            StudentEntity studentEntity = studentEntityOptional.get();
            // uplode
            studentEntity.setFirstName(modifyById.getFirstName());
            studentEntity.setEmail(modifyById.getEmail());
            studentEntity.setFatherName(modifyById.getFatherName());
            studentEntity.setMotherName(modifyById.getMotherName());
            StudentEntity student = studentRepository.save(studentEntity);
            if (student != null) {
                SuccessMessage studentResponce1 = new SuccessMessage();

                studentResponce1.setCode("0");

                studentResponce1.setStatus("OK");
                studentResponce1.setMessage("Successfully updated student detail");
                return studentResponce1;
            }
            else
            {
                SuccessMessage wrongResponse = new SuccessMessage();
                wrongResponse.setMessage("Unable to modify student detail");
                return wrongResponse;
            }
        }
        else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }
}







