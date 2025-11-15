package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {

	public Connection cn = null;
	public void ketNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.cn = DriverManager.getConnection("jdbc:sqlserver://BTYLAP:1433;databaseName=QlSach_BTVN;encrypt=true;trustServerCertificate=true;user=sa;password=123;");
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			System.out.println("Ket noi that bai");
			e.printStackTrace();
			//ketNoi();
		}
	}
}
