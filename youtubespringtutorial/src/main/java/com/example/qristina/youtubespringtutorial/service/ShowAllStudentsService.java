package com.example.qristina.youtubespringtutorial.service;

import com.example.qristina.youtubespringtutorial.domain.Student;
import com.example.qristina.youtubespringtutorial.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ShowAllStudentsService {

    private final StudentRepository studentRepository;

    @Autowired
    public ShowAllStudentsService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }


}
