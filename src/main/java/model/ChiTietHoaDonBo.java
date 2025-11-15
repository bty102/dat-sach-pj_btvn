package model;

import java.sql.SQLException;

public class ChiTietHoaDonBo {

	private ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
	
	public Long insertMotChiTietHoaDon(long maHD, String maSach, int soLuongMua) {
		Long key = null;
		try {
			key = chiTietHoaDonDao.insertMotChiTietHoaDon(maHD, maSach, soLuongMua);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}
}
