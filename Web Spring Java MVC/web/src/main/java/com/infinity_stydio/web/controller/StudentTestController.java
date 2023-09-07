package com.infinity_stydio.web.controller;

import com.infinity_stydio.web.dto.StudentDto;
import com.infinity_stydio.web.dto.StudentTestDto;
import com.infinity_stydio.web.models.Student;
import com.infinity_stydio.web.models.StudentTest;
import com.infinity_stydio.web.repository.StudentTestRepository;
import com.infinity_stydio.web.service.StudentTestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentTestController {
    private StudentTestService studentTestService;

    @Autowired
    public StudentTestController(StudentTestService studentTestService) {
        this.studentTestService = studentTestService;
    }

    @GetMapping("/studenttests/{studentId}/new")
    public String createStudentTestForm(@PathVariable("studentId") Integer studentId,
                                        Model model)
    {
        StudentTest studentTest = new StudentTest();
        model.addAttribute("studentId", studentId);
        model.addAttribute("studentTest",studentTest);
        return "studenttest-create";
    }

    @PostMapping("/studenttests/{studentTestId}")
    public String createStudentTest(@PathVariable("studentTestId") Integer studentId,
                                    @ModelAttribute("studentTest")StudentTestDto studentTestDto,
                                    BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("studentTest", studentTestDto);
            return "studenttest-create";
        }
        studentTestService.createStudentTest(studentId,studentTestDto);
        return "redirect:/students/" + studentId;
    }

    @GetMapping("/studenttests/{studentTestId}/edit")
    public String editStudentTestForm(@PathVariable("studentTestId") Integer studentTestId , Model model)
    {
        StudentTestDto studentTestDto = studentTestService.findByStudentTestId(studentTestId);
        model.addAttribute("studentTest", studentTestDto);
        return "studenttest-edit";
    }

    @PostMapping("/studenttests/{studentTestId}/edit")
    public String updateStudentTest(@PathVariable("studentTestId") Integer studentTestId,
                                @Valid @ModelAttribute("studentTest") StudentTestDto studentTestDto,
                                BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("studentTest", studentTestDto);
            return "studenttest-edit";
        }
        StudentTestDto studentTestDto1 = studentTestService.findByStudentTestId(studentTestId);
        studentTestDto.setId(studentTestId);
        studentTestDto.setStudent(studentTestDto1.getStudent());
        studentTestDto.setTest(studentTestDto1.getTest());
        studentTestService.updateStudentTest(studentTestDto);
        return "redirect:/studenttests";
    }

    @GetMapping("/studenttests")
    public String studentTestList(Model model)
    {
        List<StudentTestDto> studentTestDtos = studentTestService.findAllStudentTests();
        model.addAttribute("studentTests", studentTestDtos);
        return "studenttests-list";
    }

    @GetMapping("/studenttests/{studentTestId}")
    public String viewStudentTest(@PathVariable("studentTestId") Integer studentTestId,
                                  Model model)
    {
        StudentTestDto studentTestDto = studentTestService.findByStudentTestId(studentTestId);
        model.addAttribute("studentTest", studentTestDto);
        return "studenttest-details";
    }

    @GetMapping("/studenttests/{studentTestId}/delete")
    public String deleteStudentTest(@PathVariable("studentTestId") Integer studentTestId){
        studentTestService.deleteStudentTest(studentTestId);
        return "redirect:/studenttests";
    }
}
