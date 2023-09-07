package com.infinity_stydio.web.repository;

import com.infinity_stydio.web.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s from Student s WHERE s.username LIKE CONCAT('%', :query, '%')")
    List<Student> searchStudents(String query);
}
