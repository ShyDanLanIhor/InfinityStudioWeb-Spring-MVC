package com.infinity_stydio.web.dto;

import com.infinity_stydio.web.models.StudentTest;
import com.infinity_stydio.web.models.TestResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String questions;

    private List<StudentTestDto> studentTestDtos;
    private List<TestResult> testResults;
}
