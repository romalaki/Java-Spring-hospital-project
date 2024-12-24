package com.example.app.dao;

import com.example.app.entity.Doctor;

import java.sql.ResultSet;
import java.util.List;

public interface DoctorDAO {

    public void delete_doctor(int id);
    public void change_doctor(Doctor d);
    public Doctor getDoc(int id);
    public Iterable<Doctor> getDoctors();

    public void addDoctor(Doctor name);

}
