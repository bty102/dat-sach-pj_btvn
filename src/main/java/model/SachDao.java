package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachDao {
	
	public ArrayList<Sach> getSach() throws SQLException {
		ArrayList<Sach> ds = new ArrayList<Sach>();
//		ds.add(new Sach("s1", "Cấu trúc dữ liệu và giải thuật", "bty", 10, 200, "b1.jpg", "tin"));
//		ds.add(new Sach("s2", "Nhập môn lập trình", "bty", 10, 200, "b2.jpg", "tin"));
//		ds.add(new Sach("s3", "Toán cơ bản", "bty", 10, 200, "b3.jpg", "toan"));
//		ds.add(new Sach("s4", "Đại số tuyến tính", "bty", 10, 200, "b4.jpg", "toan"));
//		ds.add(new Sach("s5", "Mẫu thiết kế", "bty", 10, 200, "b5.jpg", "tin"));
//		ds.add(new Sach("s6", "Java nâng cao", "bty", 10, 200, "b6.jpg", "tin"));
//		ds.add(new Sach("s7", "Kỹ thuật lập trình", "loc dz", 10, 200, "b7.jpg", "tin"));
//		ds.add(new Sach("s8", "SQL cơ bản", "loc dz", 10, 200, "b8.jpg", "tin"));
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from sach";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String maSach = rs.getString("masach");
			String tenSach = rs.getString("tensach"); 
			String tacGia = rs.getString("tacgia");
			long soLuong = rs.getLong("soluong");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh"); 
			String maLoai = rs.getString("maloai");
			Sach sach = new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai);
			ds.add(sach);
		}
		return ds;
	}
	
	public List<Sach> getSach(int trang, int soSachMoiTrang) throws SQLException {
		if(trang < 1) return null;
		if(soSachMoiTrang < 1) return null;
		List<Sach> dsSach = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from sach order by masach asc offset ?*?-? rows fetch next ? rows only";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setInt(1, soSachMoiTrang);
		ps.setInt(2, trang);
		ps.setInt(3, soSachMoiTrang);
		ps.setInt(4, soSachMoiTrang);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String maSach = rs.getString("masach");
			String tenSach = rs.getString("tensach"); 
			String tacGia = rs.getString("tacgia");
			long soLuong = rs.getLong("soluong");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh"); 
			String maLoai = rs.getString("maloai");
			Sach sach = new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai);
			dsSach.add(sach);
		}
		rs.close();
		kn.cn.close();
		return dsSach;
	}
	
	public int getSoTrang(int soSachMoiTrang) throws SQLException {
		if(soSachMoiTrang <= 0) return 0;
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select CEILING(COUNT(masach)/?) as soTrang from sach";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setDouble(1, soSachMoiTrang);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int soTrang = rs.getInt("soTrang");
		return soTrang;
	}
	
	public Sach getSachById(String maSach) throws SQLException {
		for(Sach sach : getSach()) {
			if(sach.getMaSach().equals(maSach)) {
				return sach;
			}
		}
		return null;
	}
	
	public List<Sach> findByMaLoai(String maLoai, int trang, int soSachMoiTrang) throws SQLException {
		List<Sach> dsSach = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select sach.* from sach left join loai on sach.maloai = loai.maloai where loai.maloai = ? order by masach asc offset ?*?-? rows fetch next ? rows only";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setString(1, maLoai);
		ps.setInt(2, soSachMoiTrang);
		ps.setInt(3, trang);
		ps.setInt(4, soSachMoiTrang);
		ps.setInt(5, soSachMoiTrang);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String maSach = rs.getString("masach");
			String tenSach = rs.getString("tensach"); 
			String tacGia = rs.getString("tacgia");
			long soLuong = rs.getLong("soluong");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh"); 
			//String maLoai = rs.getString("maloai");
			Sach sach = new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai);
			dsSach.add(sach);
		}
		rs.close();
		kn.cn.close();
		return dsSach;
	}
	
	public List<Sach> findByTenSachOrTacGia(String key, int trang, int soSachMoiTrang) throws SQLException {
		List<Sach> dsSach = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from sach where tensach like N'%'+ ? +'%' or tacgia like N'%'+ ? +'%' order by masach asc offset ?*?-? rows fetch next ? rows only";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setNString(1, key);
		ps.setNString(2, key);
		ps.setInt(3, soSachMoiTrang);
		ps.setInt(4, trang);
		ps.setInt(5, soSachMoiTrang);
		ps.setInt(6, soSachMoiTrang);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String maSach = rs.getString("masach");
			String tenSach = rs.getString("tensach"); 
			String tacGia = rs.getString("tacgia");
			long soLuong = rs.getLong("soluong");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh"); 
			String maLoai = rs.getString("maloai");
			Sach sach = new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai);
			dsSach.add(sach);
		}
		rs.close();
		kn.cn.close();
		return dsSach;
	}
	
	public int getSoTrangWhenFindByMaLoai(String maLoai, int soSachMoiTrang) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select CEILING(COUNT(masach)/?) as soTrang from sach where maloai = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setDouble(1, soSachMoiTrang);
		ps.setNString(2, maLoai);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int soTrang = rs.getInt("soTrang");
		return soTrang;
	}
	
	public int getSoTrangWhenFindByTenSachOrTacGia(String key, int soSachMoiTrang) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select CEILING(COUNT(masach)/?) as soTrang from sach where tensach like N'%' + ? + N'%' or tacgia like N'%' + ? + N'%'";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setDouble(1, soSachMoiTrang);
		ps.setNString(2, key);
		ps.setNString(3, key);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int soTrang = rs.getInt("soTrang");
		return soTrang;
	}
}
