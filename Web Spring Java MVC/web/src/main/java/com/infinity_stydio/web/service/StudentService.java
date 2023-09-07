package com.infinity_stydio.web.service;

import com.infinity_stydio.web.dto.StudentDto;
import com.infinity_stydio.web.models.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAllStudents();
    Student saveStudent(StudentDto studentDto);

    StudentDto findStudentById(Integer studentId);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Integer studentId);

    List<StudentDto> searchStudents(String query);
}
