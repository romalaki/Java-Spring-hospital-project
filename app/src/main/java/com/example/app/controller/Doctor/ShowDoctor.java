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

import java.util.List;

@Controller
public class ShowDoctor {

   DoctorRealization docR = new DoctorRealization();

    @GetMapping("/showDoctors")
    public String ViewDoc(Model model) {
        Iterable<Doctor> d = docR.getDoctors();         //МОЖЕТ БЫТЬ ОШИБКА
        model.addAttribute("doctors",d);
        return "showDoctors";
    }

    @GetMapping("/stats")
    public String ViewStats(Model model) {
        String a = docR.longestName();
        String b = docR.popularHospital();
        String c = docR.popularProfession();
        model.addAttribute("name",a);
        model.addAttribute("popular_h",b);
        model.addAttribute("popular_p",c);

        return "stats";
    }

    @GetMapping("/docView")
    public String show(Model model) {
        List<List<Doctor>> d = docR.sortedDoctors();         //МОЖЕТ БЫТЬ ОШИБКА
        model.addAttribute("doctors",d);
        return "docView";
    }

    @GetMapping("/filter")
    public String filt(Model model) {
        List<Doctor> d = docR.getDoctors();
        HospitalRealization hosR = new HospitalRealization();
        List<Hospital>h = hosR.gethospital();
        model.addAttribute("doctors",d);
        model.addAttribute("hospitals",h);
        return "filter";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam(required = false) String doctor_name,
                         @RequestParam(required = false) String group_id,
                         @RequestParam(required = false) String doctor_type,Model model) {
        List<Doctor> d = docR.filterDoctors(doctor_type,group_id,doctor_name);
        HospitalRealization hosR = new HospitalRealization();
        List<Hospital>h = hosR.gethospital();
        model.addAttribute("doctors",d);
        model.addAttribute("hospitals",h);
        System.out.println(h.size());
        return "filter";
    }
}
