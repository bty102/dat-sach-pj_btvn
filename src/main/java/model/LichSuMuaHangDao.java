package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LichSuMuaHangDao {

	public List<LichSuMuaHang> getAll(long maKH) throws SQLException {
		List<LichSuMuaHang> lst = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from VIEW_LSMH where makh = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, maKH);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			 //long maKH = rs.getLong("makh");
			 long maHD = rs.getLong("MaHoaDon");
			 String maSach = rs.getString("masach");
			 String tenSach = rs.getString("tensach");
			 long gia = rs.getLong("gia");
			 int soLuongMua = rs.getInt("SoLuongMua");
			 long thanhTien = rs.getLong("ThanhTien");
			 Date ngayMua = new Date(rs.getDate("NgayMua").getTime());
			 boolean daMua = rs.getBoolean("DaMua");
			 
			 LichSuMuaHang lichSuMuaHang = new LichSuMuaHang(maKH, maHD, maSach, tenSach, gia, soLuongMua, thanhTien, ngayMua, daMua);
			 lst.add(lichSuMuaHang);
		}
		rs.close();
		kn.cn.close();
		return lst;
	}
	
	public List<LichSuMuaHang> get(long maKH, int page, int pageSize) throws SQLException {
		if(page < 1) page = 1;
		if(pageSize < 1) pageSize = 1;
		
		List<LichSuMuaHang> lst = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from VIEW_LSMH where makh = ? Order by MaHoaDon desc offset ?*?-? rows fetch next ? rows only";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, maKH);
		ps.setInt(2, pageSize);
		ps.setInt(3, page);
		ps.setInt(4, pageSize);
		ps.setInt(5, pageSize);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			 //long maKH = rs.getLong("makh");
			 long maHD = rs.getLong("MaHoaDon");
			 String maSach = rs.getString("masach");
			 String tenSach = rs.getString("tensach");
			 long gia = rs.getLong("gia");
			 int soLuongMua = rs.getInt("SoLuongMua");
			 long thanhTien = rs.getLong("ThanhTien");
			 Date ngayMua = new Date(rs.getDate("NgayMua").getTime());
			 boolean daMua = rs.getBoolean("DaMua");
			 
			 LichSuMuaHang lichSuMuaHang = new LichSuMuaHang(maKH, maHD, maSach, tenSach, gia, soLuongMua, thanhTien, ngayMua, daMua);
			 lst.add(lichSuMuaHang);
		}
		rs.close();
		kn.cn.close();
		return lst;
	}

	public int getSoLuongTrang(long maKH, int pageSize) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select CEILING(COUNT(*)/?) as soTrang from VIEW_LSMH where makh = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setDouble(1, pageSize);
		ps.setLong(2, maKH);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int soLuongTrang = rs.getInt("soTrang");
		return soLuongTrang;
	}
}
