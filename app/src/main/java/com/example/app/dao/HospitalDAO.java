package com.example.app.dao;

import com.example.app.entity.Hospital;

public interface HospitalDAO {

    public void delete_hospital(int id);
    public void change_hospital(Hospital d);
    public Hospital gethospital(int id);
    public Iterable<Hospital> gethospital();

    public void addhospital(Hospital name);

}
