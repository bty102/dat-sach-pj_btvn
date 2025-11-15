package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ChiTietHoaDonBo;
import model.GioHang;
import model.HoaDonBo;
import model.KhachHang;
import model.SachCuaGioHang;

/**
 * Servlet implementation class DatMuaController
 */
@WebServlet("/DatMua")
public class DatMuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatMuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		KhachHang kh = (KhachHang) session.getAttribute("un");
		if(kh == null) {
			response.sendRedirect("DangNhap");
			return;
		}
		
		GioHang gh = (GioHang) session.getAttribute("gh");
		if(gh == null || gh.getDsSach().size() == 0) {
			response.sendRedirect("TrangChu");
			return;
		}
		
		HoaDonBo hoaDonBo = new HoaDonBo();
		Long maHD = hoaDonBo.insertMotHoaDon(kh.getMaKH());
		
		ChiTietHoaDonBo chiTietHoaDonBo = new ChiTietHoaDonBo();
		
		List<SachCuaGioHang> dsSach = gh.getDsSach();
		for (SachCuaGioHang sach : dsSach) {
			chiTietHoaDonBo.insertMotChiTietHoaDon(maHD, sach.getSach().getMaSach(), sach.getSoLuong());
		}
		session.removeAttribute("gh");
		response.sendRedirect("TrangChu");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
