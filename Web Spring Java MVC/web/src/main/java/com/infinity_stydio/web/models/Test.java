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
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String name;
    private String description;
    @Column(columnDefinition = "json")
    private String questions;

    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE)
    private List<StudentTest> studentTests = new ArrayList<>();
    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE)
    private List<TestResult> testResults = new ArrayList<>();
}
