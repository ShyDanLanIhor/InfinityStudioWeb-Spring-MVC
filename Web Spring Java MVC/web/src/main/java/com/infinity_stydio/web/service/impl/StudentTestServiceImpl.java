package com.infinity_stydio.web.service.impl;

import com.infinity_stydio.web.dto.StudentTestDto;
import com.infinity_stydio.web.models.Student;
import com.infinity_stydio.web.models.StudentTest;
import com.infinity_stydio.web.repository.StudentRepository;
import com.infinity_stydio.web.repository.StudentTestRepository;
import com.infinity_stydio.web.service.StudentTestService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.infinity_stydio.web.mapper.StudentMapper.mapToStudent;
import static com.infinity_stydio.web.mapper.StudentTestMapper.mapToStudentTest;
import static com.infinity_stydio.web.mapper.StudentTestMapper.mapToStudentTestDto;

@Getter
@Data
@Service
public class StudentTestServiceImpl implements StudentTestService {
    private StudentTestRepository studentTestRepository;
    private StudentRepository studentRepository;

    @Autowired
    public StudentTestServiceImpl(StudentTestRepository studentTestRepository, StudentRepository studentRepository) {
        this.studentTestRepository = studentTestRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudentTest(Integer studentId, StudentTestDto studentTestDto) {
        Student student = studentRepository.findById(studentId).get();
        StudentTest studentTest = mapToStudentTest(studentTestDto);
        studentTest.setStudent(student);
        studentTestRepository.save(studentTest);


    }

    @Override
    public List<StudentTestDto> findAllStudentTests()
    {
        List<StudentTest> studentTests = studentTestRepository.findAll();
        return studentTests.stream().map(studentTest -> mapToStudentTestDto(studentTest)).collect(Collectors.toList());
    }

    @Override
    public StudentTestDto findByStudentTestId(Integer studentTestId) {
        StudentTest studentTest = studentTestRepository.findById(studentTestId).get();
        return  mapToStudentTestDto(studentTest);
    }

    @Override
    public void updateStudentTest(StudentTestDto studentTestDto) {
        StudentTest studentTest = mapToStudentTest(studentTestDto);
        studentTestRepository.save(studentTest);
    }

    @Override
    public void deleteStudentTest(Integer studentTestId) {
        studentTestRepository.deleteById(studentTestId);
    }


}
