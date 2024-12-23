//package com.example.app.dao;
//
//
//import com.example.app.entity.Doctor;
//
//import java.sql.*;
//import java.util.List;
//
//public class DoctorRealization extends BaseDAO implements DoctorDAO {
//
//    Connection conn = getConn();
//
//    @Override
//    public void createUser(String name, int hospital_id, String specialty) {
//        try{
//            String insert = "INSERT INTO pz5.doctor(hospital_id,name,specialty) VALUES (?,?,?);";
//            PreparedStatement ps = getConn().prepareStatement(insert);
//
//            ps.setString(1,name);
//            ps.setInt(2,hospital_id);
//            ps.setString(3,specialty);
//            ps.executeUpdate();
//
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }finally{
//            try {
//                conn.close();
//            }catch(SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    @Override
//    public void change_user(int id,String name, int hospital_id, String specialty){
//
//        try {
//            String select = "UPDATE info SET name = ?, hospital_id = ?, specialty = ? WHERE id = ?;";
//            PreparedStatement ps = getConn().prepareStatement(select);
//
//            ps.setString(1,name);
//            ps.setInt(2,hospital_id);
//            ps.setString(3,specialty);
//            ps.setInt(4,id);
//            ps.executeUpdate();
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }finally{
//            try {
//                conn.close();
//            }catch(SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    @Override
//    public Doctor getUser(int id) {
//        try {
//            String select = "SELECT * FROM info WHERE id = ?;";
//            PreparedStatement ps = getConn().prepareStatement(select);
//            ps.setInt(1,id);
//
//            ResultSet rs = ps.executeQuery();
//            Doctor us = new Doctor();
//
//            us.setSpecialty(rs.getString("specialty"));
//            us.setName(rs.getString("name"));
//            us.setId(rs.getInt("id"));
//
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }finally{
//            try {
//                conn.close();
//            }catch(SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Doctor> getUsers() {
//        return List.of();
//    }
//
//    @Override
//    public void delete_user(Doctor us){
//        try {
//            String select = "DELETE FROM person.status WHERE user_login = ?;";
//            PreparedStatement ps = getConn().prepareStatement(select);
//
//            ps.setString(1,us.login);
//            ps.executeUpdate();
//
//            select = "DELETE FROM person.message WHERE sender = ?;";
//            ps = getConn().prepareStatement(select);
//
//            ps.setString(1,us.login);
//            ps.executeUpdate();
//
//            select = "DELETE FROM person.message WHERE getter = ?;";
//            ps = getConn().prepareStatement(select);
//
//            ps.setString(1,us.login);
//            ps.executeUpdate();
//
//            select = "DELETE FROM person.info WHERE login = ?;";
//            ps = getConn().prepareStatement(select);
//
//            ps.setString(1,us.login);
//            ps.executeUpdate();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally{
//            try {
//                conn.close();
//            }catch(SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public boolean check_reg(String login,String password, String name, String lastname){
//        name=name.trim();
//        login=login.trim();
//        password=password.trim();
//        lastname=lastname.trim();
//
//        if(!login.isBlank() && !password.isBlank() && !name.isBlank() && !lastname.isBlank()){
//            DoctorRealization us = new DoctorRealization();
//
//            try {
//                ResultSet rs = us.get_name(login);
//                if(!rs.next())
//                    return true;
//
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return false;
//    }
//}
