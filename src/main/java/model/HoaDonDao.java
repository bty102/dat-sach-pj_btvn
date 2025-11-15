package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoaDonDao {

	public Long insertMotHoaDon(long maKH) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "insert into hoadon(makh, NgayMua, damua) values(?, GETDATE(), 0)";
		PreparedStatement ps = kn.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, maKH);
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
