package com.infinity_stydio.web.mapper;

import com.infinity_stydio.web.dto.StudentTestDto;
import com.infinity_stydio.web.models.StudentTest;

public class StudentTestMapper {
    public static StudentTest mapToStudentTest(StudentTestDto studentTestDto) {
        return StudentTest.builder()
                .id(studentTestDto.getId())
                .isActive(studentTestDto.getIsActive())
                .scheduledTimeToStart(studentTestDto.getScheduledTimeToStart())
                .deadlineTimeToStart(studentTestDto.getDeadlineTimeToStart())
                .isTimeRestricted(studentTestDto.getIsTimeRestricted())
                .timeLimitMinutes(studentTestDto.getTimeLimitMinutes())
                .isTimeLimited(studentTestDto.getIsTimeLimited())
                .student(studentTestDto.getStudent())
                .test(studentTestDto.getTest())
                .build();
    }

    public static StudentTestDto mapToStudentTestDto(StudentTest studentTest) {
        return StudentTestDto.builder()
                .id(studentTest.getId())
                .isActive(studentTest.getIsActive())
                .scheduledTimeToStart(studentTest.getScheduledTimeToStart())
                .deadlineTimeToStart(studentTest.getDeadlineTimeToStart())
                .isTimeRestricted(studentTest.getIsTimeRestricted())
                .timeLimitMinutes(studentTest.getTimeLimitMinutes())
                .isTimeLimited(studentTest.getIsTimeLimited())
                .student(studentTest.getStudent())
                .test(studentTest.getTest())
                .build();
    }
}
