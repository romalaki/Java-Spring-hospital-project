package com.example.app.entity;


import com.example.app.dao.HospitalRealization;

public class Doctor {


    private int id =0;
    private String name;
    private String specialty;
    private int hospitalId;
    private String hospitalName;

    public Doctor() {
    }
    public Doctor(String name, String specialty, int hospitalId) {
        super();
        this.name = name;
        this.specialty = specialty;
        this.hospitalId = hospitalId;
    }
    public Doctor(int id,String name, String specialty, int hospitalId) {
        super();
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.hospitalId = hospitalId;
    }
    public Doctor(int id,String name, String specialty, int hospitalId,String HospitalName) {
        super();
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.hospitalId = hospitalId;
        this.hospitalName = HospitalName;
    }
    public Doctor(int id,String name, String specialty,String HospitalName) {
        super();
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.hospitalId = hospitalId;
        this.hospitalName = HospitalName;
    }
    public String getHospitalName() {
        return hospitalName;
    }
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Boolean DoctorValidation(int id,String name) {
        if(name.trim().equals(""))
            return false;
        HospitalRealization hospitalR = new HospitalRealization();
        hospitalR.getConn();
        if(hospitalR.gethospital(id)==null)
            return false;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }
}

