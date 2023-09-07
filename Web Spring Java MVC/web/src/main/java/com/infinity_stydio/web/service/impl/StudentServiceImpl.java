package com.infinity_stydio.web.service.impl;

import com.infinity_stydio.web.dto.StudentDto;
import com.infinity_stydio.web.models.Student;
import com.infinity_stydio.web.repository.StudentRepository;
import com.infinity_stydio.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.infinity_stydio.web.mapper.StudentMapper.mapToStudent;
import static com.infinity_stydio.web.mapper.StudentMapper.mapToStudentDto;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> mapToStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public Student saveStudent(StudentDto studentDto) {
        Student student = mapToStudent(studentDto);
        return studentRepository.save(student);
    }

    @Override
    public StudentDto findStudentById(Integer studentId) {
        Student student = studentRepository.findById(studentId).get();
        return mapToStudentDto(student);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student student = mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<StudentDto> searchStudents(String query) {
        List<Student> students = studentRepository.searchStudents(query);
        return students.stream().map(student -> mapToStudentDto(student)).collect(Collectors.toList());
    }

}
