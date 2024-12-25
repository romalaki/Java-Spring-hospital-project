package com.example.app.dao;


import com.example.app.entity.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorRealization extends BaseDAO implements DoctorDAO {

    Connection conn = getConn();

    @Override
    public void addDoctor(Doctor d) {
        try{
            String insert = "INSERT INTO pz5.doctor(name,hospital_id,specialty) VALUES (?,?,?);";
            PreparedStatement ps = getConn().prepareStatement(insert);

            ps.setString(1,d.getName());
            ps.setInt(2,d.getHospitalId());
            ps.setString(3,d.getSpecialty());
            ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
            }catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void change_doctor(Doctor d){

        try {
            String select = "UPDATE pz5.doctor SET name = ?, hospital_id = ?, specialty = ? WHERE id = ?;";
            PreparedStatement ps = getConn().prepareStatement(select);

            ps.setString(1,d.getName());
            ps.setInt(2,d.getHospitalId());
            ps.setString(3,d.getSpecialty());
            ps.setInt(4,d.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
            }catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Doctor getDoc(int id) {
        Doctor us = null;
        try {
            String select = "SELECT * FROM pz5.doctor WHERE id = ?;";
            PreparedStatement ps = getConn().prepareStatement(select);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(!rs.next())
                return null;
            us = new Doctor();
            us.setSpecialty(rs.getString(4));
            us.setName(rs.getString(3));
            us.setId(rs.getInt(1));
            us.setHospitalId(rs.getInt(2));

        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
                return us;
            }catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Doctor> getDoctors() {
        List<Doctor> ds = new ArrayList<Doctor>();
        try {
            String select = "SELECT * FROM pz5.doctor;";
            PreparedStatement ps = getConn().prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Doctor us = new Doctor();
                us.setSpecialty(rs.getString(4));
                us.setName(rs.getString(3));
                us.setId(rs.getInt(1));
                us.setHospitalId(rs.getInt(2));
                ds.add(us);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
                return ds;
            }catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Doctor> sortedDoctors() {  //Не придумал применение
        List<Doctor> ds = new ArrayList<Doctor>();
        try {
            String select = "SELECT * FROM pz5.doctor ORDER BY hospital_id;";
            PreparedStatement ps = getConn().prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Doctor us = new Doctor();
                us.setSpecialty(rs.getString(4));
                us.setName(rs.getString(3));
                us.setId(rs.getInt(1));
                us.setHospitalId(rs.getInt(2));
                ds.add(us);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
                return ds;
            }catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String longestName() {
        String s = "";
        try {
            String st = "SELECT name FROM pz5.doctor ORDER BY CHAR_LENGTH(name) DESC LIMIT 1;";
            PreparedStatement ps = getConn().prepareStatement(st);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                s = rs.getString(1);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            return s;
        }
    }

    @Override
    public String popularHospital() {
        String s = "";
        try {
            String st = "SELECT  h.name AS hospital_name, COUNT(d.id) AS doctor_count FROM pz5.doctor d JOIN pz5.hospital h ON d.hospital_id = h.id GROUP BY h.name ORDER BY doctor_count DESC LIMIT 1;";
            PreparedStatement ps = getConn().prepareStatement(st);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                s = rs.getString(1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            return s;
        }
    }

    @Override
    public String popularProfession() {
        String s = "";
        try {
            String st = "SELECT specialty, COUNT(*) AS doctor_count FROM pz5.doctor GROUP BY specialty ORDER BY doctor_count DESC LIMIT 1;";
            PreparedStatement ps = getConn().prepareStatement(st);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                s = rs.getString(1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            return s;
        }
    }

    @Override
    public void delete_doctor(int id){
        try {
            String select = "DELETE FROM pz5.doctor WHERE id = ?;";
            PreparedStatement ps = getConn().prepareStatement(select);
            ps.setInt(1,id);
            ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
