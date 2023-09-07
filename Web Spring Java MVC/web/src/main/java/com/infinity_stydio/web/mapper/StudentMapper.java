package com.infinity_stydio.web.mapper;

import com.infinity_stydio.web.dto.StudentDto;
import com.infinity_stydio.web.models.Student;

import java.util.stream.Collectors;

import static com.infinity_stydio.web.mapper.StudentTestMapper.mapToStudentTest;
import static com.infinity_stydio.web.mapper.StudentTestMapper.mapToStudentTestDto;

public class StudentMapper {
    public static Student mapToStudent(StudentDto studentDto) {
        Student student = Student.builder()
                .id(studentDto.getId())
                .username(studentDto.getUsername())
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .email(studentDto.getEmail())
                //.studentTests(studentDto.getStudentTestDtos().stream().map((studentTestDto) -> mapToStudentTest(studentTestDto)).collect(Collectors.toList()))
                .build();
        return student;
    }

    public static StudentDto mapToStudentDto(Student student)
    {
        StudentDto studentDto = StudentDto.builder()
                .id(student.getId())
                .username(student.getUsername())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .studentTestDtos(student.getStudentTests().stream().map((studentTest) -> mapToStudentTestDto(studentTest)).collect(Collectors.toList()))
                .build();
        return studentDto;
    }
}
