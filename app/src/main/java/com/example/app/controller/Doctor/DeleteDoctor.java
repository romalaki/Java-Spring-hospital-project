package com.example.app.controller.Doctor;

import com.example.app.entity.Doctor;
import com.example.app.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DeleteDoctor {

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/deleteDoctors")
    public String deleteDocView(Model model) {
        Iterable<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors",doctors);
        return "deleteDoctors";
    }

    @PostMapping("/deleteDoctors/{id}")
    public String deleteDoc(@PathVariable(value = "id") Long id, Model model) {
        if(doctorRepository.findById(id).isEmpty())
            return "redirect:/deleteDoctors";
        doctorRepository.deleteById(id);
        return "redirect:/deleteDoctors";
    }
}
