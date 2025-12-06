package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class VerificationTokenDao {

	public Long insert(String email, String token) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "insert into VerificationToken(Email, Token) values(?, ?)";
		PreparedStatement ps = kn.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setNString(1, email);
		ps.setNString(2, token);
		int effectedRow = ps.executeUpdate();
		Long id = null;
		if(effectedRow > 0) {
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			id = rs.getLong(1);
			
		}
		kn.cn.close();
		return id;
	}
	
	public int updateVerified(long id) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "update VerificationToken set Verified = 1 where Id = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, id);
		int effectedRow = ps.executeUpdate();
		kn.cn.close();
		return effectedRow;
	}
	
	public boolean verify(long tokenId, String token) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from VerificationToken where Id = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, tokenId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			boolean verified = rs.getBoolean("Verified");
			if(verified) return false;
			Date expirationTime = new Date(rs.getTimestamp("ExpirationTime").getTime());
			Date now = new Date();
			if(expirationTime.before(now)) {
				System.out.println("Het han");
				return false;
			}
			String tk = rs.getString("Token");
			if(!tk.equals(token)) return false;
			String email = rs.getString("Email");
			String sql2 = "select MAX(Id) as newestId from VerificationToken where Email = ?";
			PreparedStatement ps2 = kn.cn.prepareStatement(sql2);
			ps2.setNString(1, email);
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			long newestId = rs2.getLong("newestId");
			if(newestId != tokenId) return false;
			return true;
		}
		return false;
	}

	public String getEmailByTokenId(long tokenId) throws SQLException {
		String email = null;
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from VerificationToken where Id = ?";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setLong(1, tokenId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			email = rs.getString("Email");
		}
		return email;
	}
}
