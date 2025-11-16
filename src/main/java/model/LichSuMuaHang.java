package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LichSuMuaHang {

	private long maKH;
	private long maHD;
	private String maSach;
	private String tenSach;
	private long gia;
	private int soLuongMua;
	private long thanhTien;
	private Date ngayMua;
	private boolean daMua;
	
	public LichSuMuaHang() {
		super();
	}
	public LichSuMuaHang(long maKH, long maHD, String maSach, String tenSach, long gia, int soLuongMua, long thanhTien,
			Date ngayMua, boolean daMua) {
		super();
		this.maKH = maKH;
		this.maHD = maHD;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.gia = gia;
		this.soLuongMua = soLuongMua;
		this.thanhTien = thanhTien;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
	}
	public long getMaKH() {
		return maKH;
	}
	public void setMaKH(long maKH) {
		this.maKH = maKH;
	}
	public long getMaHD() {
		return maHD;
	}
	public void setMaHD(long maHD) {
		this.maHD = maHD;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public int getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public long getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}
	public Date getNgayMua() {
		return ngayMua;
	}
	
	public String getNgayMuaString() {
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		return f.format(ngayMua);
	}
	
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	public boolean isDaMua() {
		return daMua;
	}
	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}
	
	
}
