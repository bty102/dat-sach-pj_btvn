package model;

import java.sql.SQLException;

import infra.MD5Encoder;

public class KhachHangBo {

	private KhachHangDao khachHangDao = new KhachHangDao();
	
	public KhachHang kiemTraDangNhap(String tenDangNhap, String matKhau) {
		KhachHang kh = null; 
		try {
			//kh = khachHangDao.timKiemTheoTenDangNhapVaMatKhau(tenDangNhap, matKhau);
			kh = khachHangDao.timKiemTheoTenDangNhap(tenDangNhap);
			if(kh == null) return null;
			MD5Encoder encoder = new MD5Encoder();
			if(!encoder.verify(matKhau, kh.getPass())) {
				return null;
			}
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
	
	public boolean createKhachHang(KhachHang kh) {
		boolean success = false;
		
		try {
			if(khachHangDao.timKiemTheoTenDangNhap(kh.getTenDangNhap()) != null) {
				success = false;
			} else {
			
				MD5Encoder encoder = new MD5Encoder();
				kh.setPass(encoder.encode(kh.getPass()));
				success = khachHangDao.insert(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	}
}
