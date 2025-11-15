package model;

import java.util.ArrayList;
import java.util.List;

public class GioHang {

	private List<SachCuaGioHang> dsSach = new ArrayList<>();
	
	public List<SachCuaGioHang> getDsSach() {
		return dsSach;
	}
	
	public void themSach(Sach obj, int soLuong) {
		if(obj == null) return;
		for(SachCuaGioHang sach : dsSach) {
			if(sach.getSach().getMaSach().equals(obj.getMaSach())) {
				return;
			}
		}
		if(soLuong <= 0) {
			return;
		}
		SachCuaGioHang sachCuaGioHang = new SachCuaGioHang(obj, soLuong);
		dsSach.add(sachCuaGioHang);
	}
	
	public double tongTien() {
		double tt = 0;
		for (SachCuaGioHang sachCuaGioHang : dsSach) {
			tt += sachCuaGioHang.getSach().getGia() * sachCuaGioHang.getSoLuong();
		}
		return tt;
	}
	
	public void xoaSach(String maSach) {
		for (SachCuaGioHang sachCuaGioHang : dsSach) {
			if(sachCuaGioHang.getSach().getMaSach().equals(maSach)) {
				dsSach.remove(sachCuaGioHang);
				return;
			}
		}
	}
	
	public void suaSoLuong(String maSach, int soLuong) {
		if(soLuong <= 0) return;
		for (SachCuaGioHang sachCuaGioHang : dsSach) {
			if(sachCuaGioHang.getSach().getMaSach().equals(maSach)) {
				sachCuaGioHang.setSoLuong(soLuong);
			}
		}
	}
}
