package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoaiDao {

	public ArrayList<Loai> getLoai() throws SQLException {
		ArrayList<Loai> ds = new ArrayList<Loai>();
//		ds.add(new Loai("tin", "Công nghệ thông tin"));
//		ds.add(new Loai("toan", "Toán ứng dụng"));
//		ds.add(new Loai("ly", "Điện tử viễn hóa học"));
//		ds.add(new Loai("sinh", "Công nghệ sinh học"));
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from loai";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String maLoai = rs.getString("maloai"); 
			String tenLoai = rs.getString("tenloai");
			Loai loai = new Loai(maLoai, tenLoai);
			ds.add(loai);
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
