package com.example.app.controller.Hospital;

import com.example.app.dao.DoctorRealization;
import com.example.app.dao.HospitalRealization;
import com.example.app.entity.Doctor;
import com.example.app.entity.Hospital;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeHospital {

    HospitalRealization docR = new HospitalRealization();

    @PostMapping("/hosChange/{id}")
    public String changeDoc(@PathVariable(value = "id") int id, @RequestParam String hospital_name,
                         @RequestParam int base_year, Model model) {
        Hospital d = docR.gethospital(id);
        d.setName(hospital_name);
        d.setBase_year(base_year);
        docR.change_hospital(d);
        return "redirect:/showHospital";
    }

    @GetMapping("/hosChange/{id}")
    public String ShowDoc(@PathVariable(value = "id") int id, Model model) {
        Hospital d = docR.gethospital(id);
        if(d == null)
            return "redirect:/showHospital";
        model.addAttribute("hospital",d);
        return "hosChange";
    }

}
