package com.example.app.controller.Doctor;

import com.example.app.dao.DoctorRealization;
import com.example.app.dao.HospitalRealization;
import com.example.app.entity.Doctor;
import com.example.app.entity.Hospital;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class DoctorController {

    @GetMapping("/")
    public String showOptions(Model model) {
        DoctorRealization docR = new DoctorRealization();
        HospitalRealization hosR = new HospitalRealization();
        List<Doctor> d = new ArrayList<>();
        List<Hospital> h = new ArrayList<>();
        try {
            docR.getConn();
            hosR.getConn();
            d= docR.getDoctors();
            h = hosR.gethospital();
        }catch (Exception e){
            return "redirect:/";
        }
        model.addAttribute("amount_d",d.size());
        model.addAttribute("amount_h",h.size());
        return "viewAll";
    }


}
