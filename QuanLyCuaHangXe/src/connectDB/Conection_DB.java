package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection_DB {
    private static Connection con;
    public Conection_DB(){
    }

    public static Connection getConect() throws ClassNotFoundException, SQLException {
    	String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyCuaHangXe";
		String user = "sa";
		String password = "sapassword";
		con = DriverManager.getConnection(url, user, password);
        return con;
    }

}
