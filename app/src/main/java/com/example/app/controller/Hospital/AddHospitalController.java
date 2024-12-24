package com.example.app.controller.Hospital;

import com.example.app.dao.DoctorRealization;
import com.example.app.dao.HospitalRealization;
import com.example.app.entity.Doctor;
import com.example.app.entity.Hospital;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddHospitalController {

    HospitalRealization docR = new HospitalRealization();

    @GetMapping("/addHospital")
    public String view(Model model) {
        return "addHospital";
    }

    @PostMapping("/addHospital")
    public String addDoc(@RequestParam String h_name,@RequestParam int h_date, Model model) {
        Hospital doc = new Hospital(h_name,h_date);
        docR.getConn();
        docR.addhospital(doc);
        return "redirect:/showHospital";
    }
}
