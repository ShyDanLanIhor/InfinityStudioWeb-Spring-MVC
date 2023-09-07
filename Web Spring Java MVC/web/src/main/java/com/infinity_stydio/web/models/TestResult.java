package com.infinity_stydio.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "testresult")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer score;
    @Column(columnDefinition = "JSON")
    private String givenAnswers;
    private LocalDateTime executionTime;
    private Integer timeTakenMinutes;

    @ManyToOne
    @JoinColumn(name = "Student_ID", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Test_ID", nullable = false)
    private Test test;
}
