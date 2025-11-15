package model;

import java.sql.SQLException;

public class HoaDonBo {

	private HoaDonDao hoaDonDao = new HoaDonDao();
	
	public Long insertMotHoaDon(long maKH) {
		Long key = null;
		try {
			key = hoaDonDao.insertMotHoaDon(maKH);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}
}
