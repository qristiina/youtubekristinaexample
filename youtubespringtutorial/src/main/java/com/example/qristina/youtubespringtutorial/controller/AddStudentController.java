package com.example.qristina.youtubespringtutorial.controller;

import com.example.qristina.youtubespringtutorial.requests.AddStudentRequest;
import com.example.qristina.youtubespringtutorial.responses.AddStudentResponse;
import com.example.qristina.youtubespringtutorial.service.AddStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddStudentController {

    @Autowired
    private AddStudentService addStudentService;


    @GetMapping(value = "/addStudent")
    public String showAddStudentPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddStudentRequest());
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String processAddStudentRequest(@ModelAttribute(value = "request") AddStudentRequest request, ModelMap modelMap) {
        AddStudentResponse response = addStudentService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "addStudent";
        } else {
            return "redirect:/welcome";
        }
    }

}
