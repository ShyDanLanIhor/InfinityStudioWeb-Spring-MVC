package com.infinity_stydio.web.dto;

import com.infinity_stydio.web.models.Student;
import com.infinity_stydio.web.models.Test;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentTestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isActive;
    private LocalDateTime scheduledTimeToStart;
    private LocalDateTime deadlineTimeToStart;
    private Boolean isTimeRestricted;
    private Integer timeLimitMinutes;
    private Boolean isTimeLimited;
    private Student student;
    private Test test;
}
