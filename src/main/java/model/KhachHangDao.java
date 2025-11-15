package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhachHangDao {

	public KhachHang timKiemTheoTenDangNhapVaMatKhau(String tenDangNhap, String matKhau) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from KhachHang where tendn = ? and pass = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setString(1, tenDangNhap);
		ps.setString(2, matKhau);
		ResultSet rs = ps.executeQuery();
		KhachHang kh = null;
		if(rs.next()) {
			long maKH = rs.getLong("makh");
			String hoTen = rs.getString("hoten"); 
			String diaChi = rs.getString("diachi"); 
			String soDienThoai = rs.getString("sodt");
			String email = rs.getString("email");
			
			kh = new KhachHang(maKH, hoTen, diaChi, soDienThoai, email, tenDangNhap, matKhau);
			
		}
		return kh;
	}
}
