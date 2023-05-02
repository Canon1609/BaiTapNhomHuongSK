package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.Login;

public class DAO_Login {
    private Connection con;
    public DAO_Login() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyCuaHangXe", "sa", "sapassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Finished!");
        }
    }
    public List<Login> TimKiem(String TK, String PW){
        List<Login> lg = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from Login where TAIKHOAN LIKE ? and MATKHAU lIKE ?");
            stmt.setString(1,TK);
            stmt.setString(2,PW);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Login ad = new Login(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                lg.add(ad);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lg;
    }
    public boolean addLogin(Login lg) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Login VALUES(?,?,?,?,?,?)");
            stmt.setString(1,lg.getHo());
            stmt.setString(2,lg.getTen());
            stmt.setString(3,lg.getTaiKhoan());
            stmt.setString(4,lg.getMail());
            stmt.setString(5,lg.getMatKhau());
            stmt.setString(6,lg.getGioiTinh());

            int n = stmt.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
