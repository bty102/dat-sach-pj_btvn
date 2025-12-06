package model;

import java.sql.SQLException;

public class KhachHangBo {

	private KhachHangDao khachHangDao = new KhachHangDao();
	
	public KhachHang kiemTraDangNhap(String tenDangNhap, String matKhau) {
		KhachHang kh = null; 
		try {
			kh = khachHangDao.timKiemTheoTenDangNhapVaMatKhau(tenDangNhap, matKhau);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kh;
	}
	
	public Boolean existByEmail(String email) {
		Boolean ex = null;
		try {
			ex = khachHangDao.existByEmail(email);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ex;
	}
}
