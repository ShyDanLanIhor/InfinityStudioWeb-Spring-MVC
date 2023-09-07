package com.infinity_stydio.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "studenttest")
public class StudentTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime scheduledTimeToStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime deadlineTimeToStart;
    private Boolean isTimeRestricted;
    private Integer timeLimitMinutes;
    private Boolean isTimeLimited;

    @ManyToOne
    @JoinColumn(name = "Student_ID", nullable = false)
    private Student student;

    // Додайте конструктори, геттери та сеттери, якщо потрібно.

    @ManyToOne
    @JoinColumn(name = "Test_ID", nullable = false)
    private Test test;

}
