package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoaiBo {

	LoaiDao loaiDao = new LoaiDao();
	
	public ArrayList<Loai> getLoai() throws SQLException {
		return loaiDao.getLoai();
	}
}
