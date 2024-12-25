package com.example.app.collection;

import com.example.app.dao.HospitalRealization;
import com.example.app.entity.Hospital;

import java.util.ArrayList;
import java.util.List;

public class HosCol {
    List<Hospital> hospital;
    HospitalRealization hospitalR = new HospitalRealization();

    public HosCol(List<Hospital> hospital) {
        this.hospital = hospital;
    }
    public HosCol() {
        hospital = new ArrayList<>();
        try {
            hospitalR.getConn();
            hospital = hospitalR.gethospital();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public HosCol(Hospital doctor) {
        hospital = new ArrayList<>();
        hospital.add(doctor);
    }

    public void addHospital(Hospital doctor) {
        hospital.add(doctor);
        try {
            hospitalR.getConn();
            hospitalR.addhospital(doctor);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteHospital(int id) {
        if( id >= 0 && id < hospital.size()){
            hospital.remove(id);
        try {
            hospitalR.getConn();
            hospitalR.delete_hospital(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }}
    }
    public void changeHospital(Hospital doctor, int id) {
        if( id >= 0 && id < hospital.size()){
            hospital.set(id, doctor);
        try {
            hospitalR.getConn();
            hospitalR.change_hospital(doctor);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }}
    }
    public Hospital getHospital(int id) {
        if( id >= 0 && id < hospital.size())
            return hospital.get(id);
        return null;
    }
    public int getSize() {
        return hospital.size();
    }
    public boolean isEmpty() {
        return hospital.isEmpty();
    }

    public List<Hospital> getHospitals() {
        return hospital;
    }
    public void setHospitals(List<Hospital> doctors) {
        this.hospital = doctors;
    }
    public void setHospitals() {
        try {
            hospitalR.getConn();
            hospital = hospitalR.gethospital();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
