package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public KhachHang timKiemTheoTenDangNhap(String tenDangNhap) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from KhachHang where tendn = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setString(1, tenDangNhap);
	
		ResultSet rs = ps.executeQuery();
		KhachHang kh = null;
		if(rs.next()) {
			long maKH = rs.getLong("makh");
			String hoTen = rs.getString("hoten"); 
			String diaChi = rs.getString("diachi"); 
			String soDienThoai = rs.getString("sodt");
			String email = rs.getString("email");
			String matKhau = rs.getString("pass");
			
			kh = new KhachHang(maKH, hoTen, diaChi, soDienThoai, email, tenDangNhap, matKhau);
			
		}
		return kh;
	}
	
	public boolean existByEmail(String email) throws SQLException {
		KetNoi ketNoi = new KetNoi();
		ketNoi.ketNoi();
		String sql = "select * from KhachHang where email = ?";
		PreparedStatement ps = ketNoi.cn.prepareStatement(sql);
		ps.setNString(1, email);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			rs.close();
			ketNoi.cn.close();
			return true;
		}
		rs.close();
		ketNoi.cn.close();
		return false;
	}
	
	public boolean insert(KhachHang kh) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "insert into KhachHang(hoten, diachi, sodt, email, tendn, pass) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setString(1, kh.getHoTen());
		ps.setString(2, kh.getDiaChi());
		ps.setString(3, kh.getSoDienThoai());
		ps.setString(4, kh.getEmail());
		ps.setString(5, kh.getTenDangNhap());
		ps.setString(6, kh.getPass());
		int soDongAnhHuong = ps.executeUpdate();
		if(soDongAnhHuong == 0) return false;
		return true;
	}
}
