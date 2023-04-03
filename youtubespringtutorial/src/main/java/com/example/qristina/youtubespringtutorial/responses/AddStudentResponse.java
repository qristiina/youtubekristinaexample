package com.example.qristina.youtubespringtutorial.responses;

import com.example.qristina.youtubespringtutorial.domain.Student;

import java.util.List;

public class AddStudentResponse extends CoreResponse {

    private Student newStudent;

    public AddStudentResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddStudentResponse(Student newStudent) {
        this.newStudent = newStudent;
    }

    public Student getNewStudent() {
        return newStudent;
    }

}
