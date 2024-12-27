package com.example.app.dao;

import com.example.app.entity.Doctor;

import java.sql.ResultSet;
import java.util.List;

public interface DoctorDAO {

    public void delete_doctor(int id);
    public void change_doctor(Doctor d);

    public Doctor getDoc(int id);
    public List<Doctor> getDoctors();
    public List<Doctor> filterDoctors(String specialty,String hospital_id,String name);
    public List<List<Doctor>> sortedDoctors();

    public String longestName();
    public String popularProfession();
    public String popularHospital();

    public void addDoctor(Doctor name);

}
