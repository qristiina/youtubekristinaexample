package com.example.qristina.youtubespringtutorial.service;

import com.example.qristina.youtubespringtutorial.domain.Student;
import com.example.qristina.youtubespringtutorial.repositories.StudentRepository;
import com.example.qristina.youtubespringtutorial.requests.AddStudentRequest;
import com.example.qristina.youtubespringtutorial.responses.AddStudentResponse;
import com.example.qristina.youtubespringtutorial.responses.CoreError;
import com.example.qristina.youtubespringtutorial.service.validators.AddStudentRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class AddStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired private AddStudentRequestValidator validator;

    public AddStudentResponse execute(AddStudentRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddStudentResponse(errors);
        }

        Student student = new Student(request.getName(), request.getEmail(), request.getDob());
        studentRepository.save(student);

        return new AddStudentResponse(student);
    }


}
