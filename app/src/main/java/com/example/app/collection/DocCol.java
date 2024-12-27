package com.example.app.collection;

import com.example.app.dao.DoctorRealization;
import com.example.app.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DocCol {
    List<Doctor> doctors;
    DoctorRealization docR = new DoctorRealization();

    public DocCol(List<Doctor> doctors) {
        this.doctors = doctors;
    }
    public DocCol() {
        doctors = new ArrayList<>();
        try {
            doctors = docR.getDoctors();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public DocCol(Doctor doctor) {
        doctors = new ArrayList<>();
        doctors.add(doctor);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        try {
            docR.addDoctor(doctor);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteDoctor(int id) {
        if( id >= 0 && id < doctors.size()){
        doctors.remove(id);
        try {
            docR.delete_doctor(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }}
    }
    public void changeDoctor(Doctor doctor, int id) {
        if( id >= 0 && id < doctors.size()) {
            doctors.set(id, doctor);
            try {
                docR.change_doctor(doctor);
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
    public Doctor getDoctor(int id) {
        if( id >= 0 && id < doctors.size())
        return doctors.get(id);
        return null;
    }
    public int getSize() {
        return doctors.size();
    }
    public boolean isEmpty() {
        return doctors.isEmpty();
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setDoctors() {
        try {
            doctors = docR.getDoctors();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
