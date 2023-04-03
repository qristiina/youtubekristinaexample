package com.example.qristina.youtubespringtutorial.service.validators;

import com.example.qristina.youtubespringtutorial.requests.AddStudentRequest;
import com.example.qristina.youtubespringtutorial.responses.CoreError;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddStudentRequestValidator {

    public List<CoreError> validate(AddStudentRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        validateEmail(request).ifPresent(errors::add);
        validateDateOfBirth(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(AddStudentRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("Name", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateEmail(AddStudentRequest request) {
        return (request.getEmail() == null || request.getEmail().isEmpty())
                ? Optional.of(new CoreError("Email", "must not be empty!"))
                : Optional.empty();
    }

    /*
    SAME AS:
    private Optional<CoreError> validateEmail(AddStudentRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("Email", "Must not be empty!"));
        } else {
            return Optional.empty();
        }
    }*/


    private Optional<CoreError> validateDateOfBirth(AddStudentRequest request) {
        LocalDate dob = request.getDob();
        if (dob == null) {
            return Optional.of(new CoreError("Date of birth", "must not be empty!"));
        } else if (dob.isAfter(LocalDate.now())) {
            return Optional.of(new CoreError("Date of birth", "must be in the past!"));
        }
        return Optional.empty();
    }


}
