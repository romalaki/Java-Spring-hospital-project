package com.example.app.controller.Doctor;

import com.example.app.entity.Doctor;
import com.example.app.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowDoctor {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/showDoctors")
    public String ViewDoc(Model model) {
        Iterable<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors",doctors);
        return "showDoctors";
    }

}
