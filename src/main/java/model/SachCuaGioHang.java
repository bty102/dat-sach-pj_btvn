package model;

public class SachCuaGioHang {

	private Sach sach;
	private int soLuong;

	public SachCuaGioHang() {
		super();
	}

	public SachCuaGioHang(Sach sach, int soLuong) {
		super();
		this.sach = sach;
		this.soLuong = soLuong;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
