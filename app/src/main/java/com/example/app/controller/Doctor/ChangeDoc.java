package com.example.app.controller.Doctor;

import com.example.app.entity.Doctor;
import com.example.app.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ChangeDoc {
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("/docChange/{id}")
    public String changeDoc(@PathVariable(value = "id") long id, @RequestParam String doctor_name,
                         @RequestParam int group_name, @RequestParam String doctor_type, Model model) {
        Doctor d= doctorRepository.findById(id).orElse(null);
        d.setName(doctor_name);
        d.setHospitalId(group_name);
        d.setSpecialty(doctor_type);
        doctorRepository.save(d);
        return "redirect:/showDoctors";
    }

    @GetMapping("/docChange/{id}")
    public String ShowDoc(@PathVariable(value = "id") long id, Model model) {
        if(doctorRepository.findById(id).isEmpty())
            return "redirect:/showDoctors";
        Optional<Doctor> d =doctorRepository.findById(id);
        ArrayList<Doctor> doctors = new ArrayList<>();
        d.ifPresent(doctors::add);
        model.addAttribute("doctor",doctors.get(0));
        return "docChange";
    }

}
