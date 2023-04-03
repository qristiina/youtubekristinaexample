package com.example.qristina.youtubespringtutorial.controller;

import com.example.qristina.youtubespringtutorial.domain.Student;
import com.example.qristina.youtubespringtutorial.service.ShowAllStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "showAllStudents")
public class ShowAllStudentsController {

    private final ShowAllStudentsService showAllStudentsService;

    @Autowired
    public ShowAllStudentsController(ShowAllStudentsService showAllStudentsService) {
        this.showAllStudentsService = showAllStudentsService;
    }

    @GetMapping
    public List<Student> getStudentsMapping(){
        return showAllStudentsService.getStudents();
    }
 }
