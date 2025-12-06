package model;

import java.sql.SQLException;

public class VerificationTokenBo {
	
	private VerificationTokenDao verificationTokenDao = new VerificationTokenDao();

	public Long insert(String email, String token) {
		Long id = null;
		try {
			id = verificationTokenDao.insert(email, token);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public Integer updateVerified(long id) {
		Integer tmp = null;
		try {
			tmp = verificationTokenDao.updateVerified(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	
	public Boolean verify(long tokenId, String token) {
		Boolean tmp = null;
		try {
			tmp = verificationTokenDao.verify(tokenId, token);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	
	public String getEmailByTokenId(long tokenId) {
		String email = null;
		try {
			email = verificationTokenDao.getEmailByTokenId(tokenId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
}
