package com.example.app.dao;

import com.example.app.entity.Doctor;

import java.sql.ResultSet;
import java.util.List;

public interface DoctorDAO {

    public void delete_user(Doctor us);
    public void change_user(int id,String name, int hospital_id, String specialty);
    public Doctor getUser(int id);
    public List<Doctor> getUsers();

    public void createUser(String name, int hospital_id, String specialty);

}
