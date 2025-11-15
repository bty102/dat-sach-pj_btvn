package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChiTietHoaDonDao {

	public Long insertMotChiTietHoaDon(long maHD, String maSach, int soLuongMua) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "insert into ChiTietHoaDon(MaHoaDon, MaSach, SoLuongMua, DaMua) values(?, ?, ?, 0)";
		PreparedStatement ps = kn.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, maHD);
		ps.setNString(2, maSach);
		ps.setInt(3, soLuongMua);
		int affectedRows = ps.executeUpdate();
		if(affectedRows > 0) {
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			Long key = rs.getLong(1);
			return key;
		} else {
			return null;
		}
		
	}
}
