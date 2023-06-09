package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.*;

public class DAO_PhieuXuat {
    private Connection con ;
    public DAO_PhieuXuat(){
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyCuaHangXe", "sa", "sapassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Finished!");
        }
    }

    public ResultSet getResultSet(String StoreName)throws Exception {
        ResultSet rs = null;
        try {
            String callStore;
            callStore = "{Call " + StoreName +"}";
            CallableStatement cs = this.con.prepareCall(callStore);
            cs.executeQuery();
            rs = cs.getResultSet();
        } catch (Exception e) {
            throw new Exception("Error get Store " + e.getMessage());
        }
        return rs;
    }


    public boolean addPhieuXuat(PhieuXuat px) {
        try {
            PreparedStatement pnAdd = con.prepareStatement("INSERT INTO PXuat VALUES(?,?,?,?)");
            pnAdd.setString(1,px.getMaPX());
            pnAdd.setString(2,px.getNgayXuat());
            pnAdd.setString(3,px.getKhachHang().getMaKH());
            pnAdd.setString(4,px.getNhanVien().getMaNV());

            int n = pnAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deletePhieuXuat(String maPX) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete from PhieuXuat where MaPX = ?");
            stmt.setString(1, maPX);
            int n = stmt.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<PhieuXuat> getLS() throws Exception {
        List<PhieuXuat> ds = new ArrayList<>();
        try {
            //PreparedStatement stmt = con.prepareStatement("select * from KhachHang");
            ResultSet rs = getResultSet("select_PX");
            while(rs.next()){
                PhieuXuat px = new PhieuXuat(rs.getString(1),rs.getString(2));
                px.setKhachHang(new KhachHang(rs.getString(3).toString()));
                px.setNhanVien(new NhanVien(rs.getString(4)));
                ds.add(px);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }


    public List<PhieuXuat> TimKiem(String maPX){
        List<PhieuXuat> px = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from PXuat where MAPX = ?");
            stmt.setString(1,maPX);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                PhieuXuat px1 = new PhieuXuat(rs.getString(1),rs.getString(2));
                px1.setKhachHang(new KhachHang(rs.getString(3).toString()));
                px1.setNhanVien(new NhanVien(rs.getString(4)));
                px.add(px1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return px;
    }
    public PhieuXuat TimKiemPX(String maPX){
        PhieuXuat px1 = null;
        DAO_KhachHang khDao = new DAO_KhachHang();
        DAO_NhanVien nvDao = new DAO_NhanVien();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from PXuat where MAPX = ?");
            stmt.setString(1,maPX);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                px1 = new PhieuXuat(rs.getString(1),rs.getString(2));
                px1.setKhachHang(khDao.TimKiemKH(rs.getString(3).toString()));
                px1.setNhanVien(nvDao.TimKiemNV(rs.getString(4)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return px1;
    }

    public List<PhieuXuat> TimKiemThang(String thang,String nam){
        List<PhieuXuat> px = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from PXuat where MONTH(NGAYXUAT) = ? and YEAR(NGAYXUAT) = ?");
            stmt.setString(1,thang);
            stmt.setString(2,nam);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                PhieuXuat px1 = new PhieuXuat(rs.getString(1),rs.getString(2));
                px1.setKhachHang(new KhachHang(rs.getString(3).toString()));
                px1.setNhanVien(new NhanVien(rs.getString(4)));
                px.add(px1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return px;
    }
    public List<PhieuXuat> TimKiemQuy(String quy,String nam){
        List<PhieuXuat> px = new ArrayList<>();
        PreparedStatement stmt = null;
        try{
            if(Integer.parseInt(quy)==1) {
                stmt = con.prepareStatement("select * from PXuat where MONTH(NGAYXUAT) between ? and ? and YEAR(NGAYXUAT) = ?");
                stmt.setString(1, "1");
                stmt.setString(2,"3");
                stmt.setString(3, nam);
            }
            else if(Integer.parseInt(quy)==2){
                stmt = con.prepareStatement("select * from PXuat where MONTH(NGAYXUAT) between ? and ? and YEAR(NGAYXUAT) = ?");
                stmt.setString(1, "4");
                stmt.setString(2,"6");
                stmt.setString(3, nam);
            }
            else if(Integer.parseInt(quy)==3){
                stmt = con.prepareStatement("select * from PXuat where MONTH(NGAYXUAT) between ? and ? and YEAR(NGAYXUAT) = ?");
                stmt.setString(1, "7");
                stmt.setString(2,"9");
                stmt.setString(3, nam);
            }
            else{
                stmt = con.prepareStatement("select * from PXuat where MONTH(NGAYXUAT) between ? and ? and YEAR(NGAYXUAT) = ?");
                stmt.setString(1, "10");
                stmt.setString(2,"12");
                stmt.setString(3, nam);
            }

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                PhieuXuat px1 = new PhieuXuat(rs.getString(1),rs.getString(2));
                px1.setKhachHang(new KhachHang(rs.getString(3).toString()));
                px1.setNhanVien(new NhanVien(rs.getString(4)));
                px.add(px1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return px;
    }

}
