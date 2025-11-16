package model;

import java.sql.SQLException;
import java.util.List;

public class LichSuMuaHangBo {
	
	private LichSuMuaHangDao lichSuMuaHangDao = new LichSuMuaHangDao();

	public List<LichSuMuaHang> getAll(long maKH) {
		List<LichSuMuaHang> lst = null;

		try {
			lst = lichSuMuaHangDao.getAll(maKH);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lst;
	}
	
	public List<LichSuMuaHang> get(long maKH, int page, int pageSize) {
		List<LichSuMuaHang> lst = null;
		try {
			lst = lichSuMuaHangDao.get(maKH, page, pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	public int getSoLuongTrang(long maKH, int pageSize) {
		int soLuongTrang = 0;
		try {
			soLuongTrang = lichSuMuaHangDao.getSoLuongTrang(maKH, pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soLuongTrang;
	}
}
