package com.example.app.controller.Doctor;

import com.example.app.dao.DoctorRealization;
import com.example.app.entity.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class DeleteDoctor {


    DoctorRealization docR = new DoctorRealization();

    @GetMapping("/deleteDoctors")
    public String deleteDocView(Model model) {
        docR.getConn();
        Iterable<Doctor> d = docR.getDoctors();         //МОЖЕТ БЫТЬ ОШИБКА
        model.addAttribute("doctors",d);
        return "deleteDoctors";
    }

    @PostMapping("/deleteDoctors/{id}")
    public String deleteDoc(@PathVariable(value = "id") int id, Model model) {
        docR.getConn();
        Doctor d = docR.getDoc(id);
        if(d==null)
            return "redirect:/deleteDoctors";
        docR.delete_doctor(id);
        return "redirect:/deleteDoctors";
    }
}
