package com.example.app.controller.Doctor;

import com.example.app.dao.DoctorRealization;
import com.example.app.entity.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowDoctor {

   DoctorRealization docR = new DoctorRealization();

    @GetMapping("/showDoctors")
    public String ViewDoc(Model model) {
        docR.getConn();
        Iterable<Doctor> d = docR.getDoctors();         //МОЖЕТ БЫТЬ ОШИБКА
        model.addAttribute("doctors",d);
        return "showDoctors";
    }

}
