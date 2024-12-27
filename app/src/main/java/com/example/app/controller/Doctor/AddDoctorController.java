package com.example.app.controller.Doctor;

import com.example.app.dao.DoctorRealization;
import com.example.app.dao.HospitalRealization;
import com.example.app.entity.Doctor;
import com.example.app.entity.Hospital;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class AddDoctorController {

    DoctorRealization docR = new DoctorRealization();

    @GetMapping("/addDoctor")
    public String view(Model model) {
        try {
            HospitalRealization hosR = new HospitalRealization();
            Iterable<Hospital> h = hosR.gethospital();
            model.addAttribute("hospitals",h);
        }catch (Exception e){
            return "redirect:/";
        }
        return "addDoctor";
    }

    @PostMapping("/addDoctor")
    public String addDoc(@RequestParam String doctor_name,@RequestParam int group_name,@RequestParam String doctor_type, Model model) {
        Doctor doc = new Doctor(doctor_name,doctor_type,group_name);
        if(!doc.DoctorValidation(group_name,doctor_name))
            return "redirect:/addDoctor";
        try {
            docR.addDoctor(doc);
        }catch (Exception e){
            return "redirect:/";
        }
        return "redirect:/docView";
    }
}
