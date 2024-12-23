package com.example.app.controller.Doctor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
public class DoctorController {

    @GetMapping("/")
    public String showOptions(Model model) {
        model.addAttribute("amount","1");
        return "index";
    }


}
