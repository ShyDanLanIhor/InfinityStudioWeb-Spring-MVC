package com.infinity_stydio.web.service;

import com.infinity_stydio.web.dto.StudentTestDto;
import com.infinity_stydio.web.models.StudentTest;

import java.util.List;

public interface StudentTestService {
    void createStudentTest(Integer studentId, StudentTestDto studentTestDto);
    List<StudentTestDto> findAllStudentTests();

    StudentTestDto findByStudentTestId(Integer studentTestId);

    void updateStudentTest(StudentTestDto studentTestDto);

    void deleteStudentTest(Integer studentTestId);
}
