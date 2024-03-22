/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.dto.HoaDonChiTietDTO;
import app.model.ChiTietSanPham;
import app.model.HoaDon;
import app.model.KhachHang;
import app.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author admin
 */
public class HoaDonChiTietService {
    
   
    

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String sql = "";

    Connection connection = null;
    
    List<HoaDonChiTietDTO > hoaDonChiTietDTOs = null;

    public List<HoaDonChiTietDTO> getHoaDonChiTietDTO(int idHoaDon) {
           
        hoaDonChiTietDTOs = new ArrayList<>();
        sql = "SELECT [id_HoaDon]\n"
                + "      ,[id_CTSP]\n"
                + "      ,[donGia]\n"
                + "      ,[soLuong]\n"
                + "      , HoaDonChiTiet.trangThaiXoa\n"
                + "      ,HoaDonChiTiet.ngayTao\n"
                + "      ,HoaDonChiTiet.ngaySuaCuoi,\n"
                + "	  SanPham.ten,\n"
                + "	  ChiTietSanPham.giaBan\n"
                + "FROM [dbo].[HoaDonChiTiet] join HoaDon on HoaDon.id = HoaDonChiTiet.id_HoaDon join ChiTietSanPham on ChiTietSanPham.id = HoaDonChiTiet.id_CTSP join SanPham on ChiTietSanPham.id_SanPham = SanPham.id where HoaDon.id = ? \n"
                + "" ;
        
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, idHoaDon);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {                
                HoaDonChiTietDTO hoaDonChiTietDTO = new HoaDonChiTietDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getLong(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getDate(6),
                        resultSet.getDate(7), 
                        resultSet.getString(8), 
                        resultSet.getLong(9));
                
                hoaDonChiTietDTOs.add(hoaDonChiTietDTO);
            }
            
            return hoaDonChiTietDTOs;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
        
    }

    public int taoHoaDonByHoaDonChiTietNhanVienAndKhachHang(List<ChiTietSanPham> listChiTietSanPham, NhanVien nhanVienBanHang, KhachHang khachHang) {
        try {
            UUID uuid = UUID.randomUUID();
            String maHoaDon = uuid.toString();
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMaHoaDon(maHoaDon);
            hoaDon.setHinhThucThanhToan(null);
            hoaDon.setIdKhachHang(-1);
            hoaDon.setIdNhanVien(nhanVienBanHang.getId());
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

}
