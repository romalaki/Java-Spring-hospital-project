package com.example.app.controller.Doctor;

import com.example.app.dao.DoctorRealization;
import com.example.app.entity.Doctor;
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

    DoctorRealization docR = new DoctorRealization();

    @PostMapping("/docChange/{id}")
    public String changeDoc(@PathVariable(value = "id") int id, @RequestParam String doctor_name,
                         @RequestParam int group_name, @RequestParam String doctor_type, Model model) {
        docR.getDoc(id);
        docR.getConn();
        Doctor d = docR.getDoc(id);
        d.setName(doctor_name);
        d.setHospitalId(group_name);
        d.setSpecialty(doctor_type);
        docR.change_doctor(d);
        return "redirect:/showDoctors";
    }

    @GetMapping("/docChange/{id}")
    public String ShowDoc(@PathVariable(value = "id") int id, Model model) {
        docR.getConn();
        Doctor d = docR.getDoc(id);
        if(d == null)
            return "redirect:/showDoctors";
        model.addAttribute("doctor",d);
        return "docChange";
    }

}
