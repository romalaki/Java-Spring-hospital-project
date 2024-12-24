package com.example.app.controller.Hospital;

import com.example.app.dao.HospitalRealization;
import com.example.app.entity.Hospital;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowHospital {

   HospitalRealization docR = new HospitalRealization();

    @GetMapping("/showHospital")
    public String ViewDoc(Model model) {
        docR.getConn();
        Iterable<Hospital> d = docR.gethospital();         //МОЖЕТ БЫТЬ ОШИБКА
        model.addAttribute("hospitals",d);
        return "showHospital";
    }

}
