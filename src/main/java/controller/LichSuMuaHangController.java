package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.KhachHang;
import model.LichSuMuaHang;
import model.LichSuMuaHangBo;
import model.Loai;
import model.LoaiBo;

/**
 * Servlet implementation class LichSuMuaHangController
 */
@WebServlet("/LichSuMuaHang")
public class LichSuMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuMuaHangController() {
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
		
		LoaiBo loaiBo = new LoaiBo();
		List<Loai> dsLoai = null;
		try {
			dsLoai = loaiBo.getLoai();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("dsLoai", dsLoai);
		
		String txtPage = request.getParameter("page");
		int page = 1;
		LichSuMuaHangBo lichSuMuaHangBo = new LichSuMuaHangBo();
		if(txtPage != null) {
			page = Integer.parseInt(txtPage);
		}
		
		List<LichSuMuaHang> lichSuMuaHang = lichSuMuaHangBo.get(kh.getMaKH(), page, 6);
		request.setAttribute("lichSuMuaHang", lichSuMuaHang);
		int soLuongTrang = lichSuMuaHangBo.getSoLuongTrang(kh.getMaKH(), 6);
		request.setAttribute("soLuongTrang", soLuongTrang);
		request.setAttribute("currentPage", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("lich-su-mua-hang.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
