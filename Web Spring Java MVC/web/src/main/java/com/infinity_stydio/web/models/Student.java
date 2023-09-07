package com.infinity_stydio.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = (50))
    private String username;
    @Column(length = (50))
    private String firstName;
    @Column(length = (50))
    private String lastName;
    @Column(length = (100))
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    private List<StudentTest> studentTests = new ArrayList<>();
    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    private List<TestResult> testResults = new ArrayList<>();
}
