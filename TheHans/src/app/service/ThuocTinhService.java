/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.ChatLieu;
import app.model.Hang;
import app.model.KichCo;
import app.model.MauSac;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ThuocTinhService {

    List<ChatLieu> listChatLieu;
    List<Hang> listHang;
    List<KichCo> listKichCo;
    List<MauSac> listMauSac;

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<ChatLieu> getAllChatLieu() {
        listChatLieu = new ArrayList<>();
        sql = "select machatlieu,ten,trangthaixoa,ngaytao,ngaysuacuoi from chatlieu";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listChatLieu.add(cl);
            }
            return listChatLieu;
        } catch (Exception e) {
            return null;
        }
    }

    public List<MauSac> getAllMauSac() {
        listMauSac = new ArrayList<>();
        sql = "select maMauSac,ten,trangthaixoa,ngaytao,ngaysuacuoi from MauSac";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listMauSac.add(ms);
            }
            return listMauSac;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Hang> getAllHang() {
        listHang = new ArrayList<>();
        sql = "select maHang,ten,trangthaixoa,ngaytao,ngaysuacuoi from Hang";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Hang h = new Hang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listHang.add(h);
            }
            return listHang;
        } catch (Exception e) {
            return null;
        }
    }

    public List<KichCo> getAllKichCo() {
        listKichCo = new ArrayList<>();
        sql = "select makichco,ten,trangthaixoa,ngaytao,ngaysuacuoi from kichco";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KichCo kc = new KichCo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listKichCo.add(kc);
            }
            return listKichCo;
        } catch (Exception e) {
            return null;
        }
    }

    public int addChatLieu(ChatLieu cl) {

        sql = "insert into ChatLieu\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getMaChatLieu());
            ps.setString(2, cl.getTen());
            ps.setInt(3, cl.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int addHang(Hang h) {

        sql = "insert into Hang\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, h.getMaHang());
            ps.setString(2, h.getTen());
            ps.setInt(3, h.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int addKichCo(KichCo kc) {

        sql = "insert into KichCo\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kc.getMaKichCo());
            ps.setString(2, kc.getTen());
            ps.setInt(3, kc.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int addMauSac(MauSac ms) {

        sql = "insert into MauSac\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ms.getMaMauSac());
            ps.setString(2, ms.getTen());
            ps.setInt(3, ms.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int suaChatLieu(ChatLieu cl, String ma) {
        sql = "update ChatLieu set maChatLieu = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maChatLieu = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getMaChatLieu());
            ps.setString(2, cl.getTen());
            ps.setInt(3, cl.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int suaHang(Hang h, String ma) {
        sql = "update Hang set maHang = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maHang = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, h.getMaHang());
            ps.setString(2, h.getTen());
            ps.setInt(3, h.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int suaKichCo(KichCo cl, String ma) {
        sql = "update KichCo set maKichCo = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maKichCo = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getMaKichCo());
            ps.setString(2, cl.getTen());
            ps.setInt(3, cl.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int suaMauSac(MauSac cl, String ma) {
        sql = "update MauSac set maMauSac = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maMauSac = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getMaMauSac());
            ps.setString(2, cl.getTen());
            ps.setInt(3, cl.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        List<KichCo> list = new ArrayList<>();
        ThuocTinhService qld = new ThuocTinhService();
        list = qld.getAllKichCo();
        for (KichCo grade : list) {
            System.out.println(grade.toString());
        }
    }
}
