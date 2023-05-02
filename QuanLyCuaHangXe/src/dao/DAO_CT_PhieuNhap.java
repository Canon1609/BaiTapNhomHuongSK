package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.CT_PhieuNhap;

public class DAO_CT_PhieuNhap {
	private Connection con;

	public DAO_CT_PhieuNhap() {
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyCuaHangXe", "sa",
					"sapassword");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finished!");
		}

	}

	/**
	 * Đây là một phương thức trong Java được sử dụng để gọi một stored procedure
	 * Thu tuc duoc luu tru trong cơ sở dữ liệu và trả về kết quả dưới dạng
	 * ResultSet.
	 * 
	 * Cụ thể, phương thức này có một tham số là StoreName, đại diện cho tên của
	 * stored procedure cần được gọi. Nó tạo một chuỗi gọi stored procedure bằng
	 * cách sử dụng biến StoreName và đặt nó vào biến callStore. Sau đó, nó sử dụng
	 * đối tượng CallableStatement để chuẩn bị và thực thi gọi stored procedure.
	 * 
	 * Nếu gọi stored procedure thành công, phương thức sẽ trả về ResultSet chứa các
	 * kết quả của stored procedure. Nếu xảy ra lỗi trong quá trình gọi stored
	 * procedure hoặc trong quá trình truy xuất ResultSet, phương thức sẽ ném ra một
	 * ngoại lệ và thông báo lỗi.
	 * 
	 * @param StoreName
	 * @return
	 * @throws Exception
	 */
	public ResultSet getResultSet(String StoreName) throws Exception {
		ResultSet rs = null;
		try {
			String callStore;
			callStore = "{Call " + StoreName + "}";
			CallableStatement cs = this.con.prepareCall(callStore);
			cs.executeQuery();
			rs = cs.getResultSet();
		} catch (Exception e) {
			throw new Exception("Error get Store " + e.getMessage());
		}
		return rs;
	}

	public boolean addCTPhieuNhap(CT_PhieuNhap ctPN) {
		try {
			PreparedStatement pnAdd = con.prepareStatement("INSERT INTO CTPNhap VALUES(?,?,?,?,?,?)");
			pnAdd.setString(1, ctPN.getpNhap().getMaPN());
			pnAdd.setString(2, ctPN.getLoaiXe().getMaLoai());
			pnAdd.setString(3, ctPN.getLoaiXe().getTenLoaiXe());
			pnAdd.setInt(4, ctPN.getLoaiXe().getSoLuong());
			pnAdd.setDouble(6, ctPN.getLoaiXe().getDonGia());
			pnAdd.setDouble(5, ctPN.getThue());

			int n = pnAdd.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public CT_PhieuNhap TimKiemPN(String maPN) {
		CT_PhieuNhap ctpn = null;
		DAO_PhieuNhap pnDao = new DAO_PhieuNhap();
		DAO_LoaiXe lxDao = new DAO_LoaiXe();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from CTPNhap where MAPN = ?");
			stmt.setString(1, maPN);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ctpn = new CT_PhieuNhap(rs.getDouble(5));
				ctpn.setpNhap(pnDao.TimKiemPN(rs.getString(1)));
				ctpn.setLoaiXe(lxDao.TimKiemLX(rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ctpn;
	}

	/**
	 * Đây là một phương thức trong Java được sử dụng để lấy danh sách khách hàng từ
	 * cơ sở dữ liệu và trả về dưới dạng một danh sách (List) các đối tượng
	 * KhachHang.
	 * 
	 * Cụ thể, phương thức này sử dụng phương thức getResultSet("select_KH") để thực
	 * hiện truy vấn và lấy ResultSet chứa các bản ghi từ bảng KhachHang trong cơ sở
	 * dữ liệu. Sau đó, nó lặp qua ResultSet này và tạo một đối tượng KhachHang mới
	 * từ mỗi bản ghi, sau đó thêm đối tượng này vào danh sách ds. Cuối cùng, phương
	 * thức trả về danh sách này.
	 * 
	 * Nếu xảy ra lỗi trong quá trình truy xuất cơ sở dữ liệu, phương thức sẽ ném ra
	 * một ngoại lệ và in ra thông tin lỗi.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CT_PhieuNhap> getLS() throws Exception {
		List<CT_PhieuNhap> ds = new ArrayList<>();
		DAO_PhieuNhap pnDao = new DAO_PhieuNhap();
		DAO_LoaiXe lxDao = new DAO_LoaiXe();
		try {
			// PreparedStatement stmt = con.prepareStatement("select * from KhachHang");
			ResultSet rs = getResultSet("select_CTPN");
			while (rs.next()) {
				CT_PhieuNhap ctpn = new CT_PhieuNhap(rs.getDouble(5));
				ctpn.setpNhap(pnDao.TimKiemPN(rs.getString(1)));
				ctpn.setLoaiXe(lxDao.TimKiemLX(rs.getString(2)));
				ds.add(ctpn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
}
