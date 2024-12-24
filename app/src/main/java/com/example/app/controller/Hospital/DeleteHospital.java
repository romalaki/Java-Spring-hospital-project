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


@Controller
public class DeleteHospital {


    HospitalRealization docR = new HospitalRealization();

    @GetMapping("/deleteHospitals")
    public String deleteHosView(Model model) {
        docR.getConn();
        Iterable<Hospital> d = docR.gethospital();         //МОЖЕТ БЫТЬ ОШИБКА
        model.addAttribute("hospitals",d);
        return "deleteHospitals";
    }

    @PostMapping("/deleteHospitals/{id}")
    public String deleteDoc(@PathVariable(value = "id") int id, Model model) {
        docR.getConn();
        Hospital d = docR.gethospital(id);
        if(d==null)
            return "redirect:/deleteHospitals";
        docR.delete_hospital(id);
        return "redirect:/deleteHospitals";
    }
}
