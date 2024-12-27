package com.example.app.dao;

import com.example.app.entity.Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalRealization extends BaseDAO implements HospitalDAO {


    @Override
    public void delete_hospital(int id) {
        try {
            Connection conn = getConn();
            DoctorRealization dr = new DoctorRealization();
            List d =dr.filterDoctors(null,String.valueOf(id),null);
            if(!d.isEmpty())
                return;
            String select = "DELETE FROM pz5.hospital WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1,id);
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void change_hospital(Hospital d) {
        try {
            Connection conn = getConn();
            String select = "UPDATE pz5.hospital SET name = ?, base_year = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(select);

            ps.setString(1,d.getName());
            ps.setInt(2,d.getBase_year());
            ps.setInt(3,d.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
            }catch(SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Hospital gethospital(int id) {
        Hospital us = null;
        try {
            Connection conn = getConn();
            String select = "SELECT * FROM pz5.hospital WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(!rs.next())
                return null;
            us = new Hospital();
            us.setId(rs.getInt(1));
            us.setName(rs.getString(2));
            us.setBase_year(rs.getInt(3));

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
                return us;
            }catch(SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Hospital> gethospital() {
        List<Hospital> ds = new ArrayList<Hospital>();
        try {
            Connection conn = getConn();
            String select = "SELECT * FROM pz5.hospital;";
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Hospital us = gethospital(rs.getInt(1));
                ds.add(us);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
                return ds;
            }catch(SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void addhospital(Hospital h) {
        try{
            Connection conn = getConn();
            String insert = "INSERT INTO pz5.hospital(name,base_year) VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(insert);

            ps.setString(1,h.getName());
            ps.setInt(2,h.getBase_year());
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
            }catch(SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
