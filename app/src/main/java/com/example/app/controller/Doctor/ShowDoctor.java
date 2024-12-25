package com.example.app.controller.Doctor;

import com.example.app.dao.DoctorRealization;
import com.example.app.entity.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    @GetMapping("/showDoctorsByHospital")
    public String ViewStats(Model model) {
        docR.getConn();
        String a = docR.longestName();
        String b = docR.popularHospital();
        String c = docR.popularProfession();
        model.addAttribute("name",a);
        model.addAttribute("popular_h",b);
        model.addAttribute("popular_p",c);

        return "showDoctorsByHospital";
    }

    @GetMapping("/docView")
    public String show(Model model) {
        docR.getConn();
        Iterable<Doctor> d = docR.getDoctors();         //МОЖЕТ БЫТЬ ОШИБКА
        model.addAttribute("doctors",d);
        return "docView";
    }

}
