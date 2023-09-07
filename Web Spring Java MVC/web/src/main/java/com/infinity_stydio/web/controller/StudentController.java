package com.infinity_stydio.web.controller;

import com.infinity_stydio.web.dto.StudentDto;
import com.infinity_stydio.web.models.Student;
import com.infinity_stydio.web.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model)
    {
        List<StudentDto> students = studentService.findAllStudents();
        model.addAttribute("students", students);
        return "students-list";
    }

    @GetMapping("/students/search")
    public String searchStudent(@RequestParam(value = "query") String query,
                                Model model)
    {
        List<StudentDto> studentDtos = studentService.searchStudents(query);
        model.addAttribute("students",studentDtos);
        return "students-list";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model)
    {
        Student student = new Student();
        model.addAttribute("student",student);
        return "student-create";
    }

    @PostMapping("/students/new")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto,
                              BindingResult result,
                              Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("student", studentDto);
            return "student-create";
        }
        studentService.saveStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}")
    public String studentDetail(@PathVariable("studentId") Integer studentId, Model model)
    {
        StudentDto studentDto = studentService.findStudentById(studentId);
        model.addAttribute("student", studentDto);
        return "student-detail";
    }

    @GetMapping("/students/{studentId}/edit")
    public String editStudentForm(@PathVariable("studentId") Integer studentId , Model model)
    {
        StudentDto studentDto = studentService.findStudentById(studentId);
        model.addAttribute("student", studentDto);
        return "student-edit";
    }

    @PostMapping("/students/{studentId}/edit")
    public String updateStudent(@PathVariable("studentId") Integer studentId,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("student", studentDto);
            return "student-edit";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Integer studentId)
    {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }
}
