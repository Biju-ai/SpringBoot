package com.Student.Student_Detail.Repositaty;

import com.Student.Student_Detail.Entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailRepo extends JpaRepository<StudentDetail,Long> {
}
