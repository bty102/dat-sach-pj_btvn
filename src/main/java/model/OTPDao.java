package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OTPDao {

	public void insert(String OTP, String email) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "insert into OTP(Email, OTPCode, ExpirationTime, Verified) values(?, ?, DATEADD(MINUTE, 1, GETDATE()), 0)";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, OTP);
		ps.executeUpdate();
	}
}
