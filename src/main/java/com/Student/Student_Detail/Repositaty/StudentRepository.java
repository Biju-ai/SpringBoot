package com.Student.Student_Detail.Repositaty;

import com.Student.Student_Detail.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {


    boolean existsByFirstName(String firstName);

    void removeByFirstName(String firstName);

    StudentEntity findByFirstName(String firstName);
}
