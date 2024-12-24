package com.example.app.controller.Doctor;

import com.example.app.dao.DoctorRealization;
import com.example.app.entity.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddDoctorController {

    DoctorRealization docR = new DoctorRealization();

    @GetMapping("/addDoctor")
    public String view(Model model) {
        return "addDoctor";
    }

    @PostMapping("/addDoctor")
    public String addDoc(@RequestParam String doctor_name,@RequestParam int group_name,@RequestParam String doctor_type, Model model) {
        System.out.println(group_name);
        Doctor doc = new Doctor(doctor_name,doctor_type,group_name);
        docR.getConn();
        docR.addDoctor(doc);
        return "redirect:/showDoctors";
    }
}
