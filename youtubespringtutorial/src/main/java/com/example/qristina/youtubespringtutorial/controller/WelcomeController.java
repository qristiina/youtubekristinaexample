package com.example.qristina.youtubespringtutorial.controller;

import com.example.qristina.youtubespringtutorial.domain.Student;
import com.example.qristina.youtubespringtutorial.service.ShowAllStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WelcomeController {

    private final ShowAllStudentsService showAllStudentsService;

    @Autowired
    public WelcomeController(ShowAllStudentsService showAllStudentsService) {
        this.showAllStudentsService = showAllStudentsService;
    }
    @GetMapping("/welcome")
    public String home() {
        return "welcome";
    }

    @GetMapping("/table")
    public String getStudentsTable(Model model) {
        List<Student> students = showAllStudentsService.getStudents();
        model.addAttribute("students", students);
        return "studentsTable";
    }

}
