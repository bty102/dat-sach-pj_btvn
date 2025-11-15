package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachBo {

	SachDao sachDao = new SachDao();
	
	ArrayList<Sach> dsSach;
	
	public ArrayList<Sach> getSach() throws SQLException {
		dsSach = sachDao.getSach();
		return dsSach;
	}
	
	public List<Sach> getSach(int trang, int soSachMoiTrang) {
		List<Sach> dsSach = null;
		try {
			dsSach = sachDao.getSach(trang, soSachMoiTrang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSach;
	}
	
	public int getSoTrang(int soSachMoiTrang) {
		int soTrang = 0;
		try {
			soTrang = sachDao.getSoTrang(soSachMoiTrang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soTrang;
	}
	
	public ArrayList<Sach> findByMaLoai(String maLoai) throws SQLException {
		getSach();
		ArrayList<Sach> tmp = new ArrayList<>();
		for(Sach sach : dsSach) {
			if(sach.getMaLoai().equals(maLoai)) {
				tmp.add(sach);
			}
		}
		return tmp;
	}
	
	public List<Sach> findByMaLoai(String maLoai, int trang, int soSachMoiTrang) {
		List<Sach> dsSach = null;
		try {
			dsSach = sachDao.findByMaLoai(maLoai, trang, soSachMoiTrang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSach;
	}
	
	public ArrayList<Sach> findByTenSachOrTacGia(String key) throws SQLException {
		getSach();
		ArrayList<Sach> tmp = new ArrayList<>();
		for(Sach sach : dsSach) {
			if(sach.getTenSach().toLowerCase().contains(key.toLowerCase().trim())
				|| sach.getTacGia().toLowerCase().contains(key.trim().toLowerCase())) {
				tmp.add(sach);
			}
		}
		return tmp;
	}
	
	public List<Sach> findByTenSachOrTacGia(String key, int trang, int soSachMoiTrang) {
		List<Sach> dsSach = null;
		try {
			dsSach = sachDao.findByTenSachOrTacGia(key, trang, soSachMoiTrang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSach;
	}
	
	public Sach getSachById(String maSach) throws SQLException {
		return sachDao.getSachById(maSach);
	}
	
	public int getSoTrangWhenFindByMaLoai(String maLoai, int soSachMoiTrang) {
		int soTrang = 0;
		try {
			soTrang = sachDao.getSoTrangWhenFindByMaLoai(maLoai, soSachMoiTrang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soTrang;
	}
	
	public int getSoTrangWhenFindByTenSachOrTacGia(String key, int soSachMoiTrang) {
		int soTrang = 0;
		try {
			soTrang = sachDao.getSoTrangWhenFindByTenSachOrTacGia(key, soSachMoiTrang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soTrang;
	}
}
