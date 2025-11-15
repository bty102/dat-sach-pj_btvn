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

import model.GioHang;
import model.Loai;
import model.LoaiBo;
import model.Sach;
import model.SachBo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHang")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("un") == null) {
			response.sendRedirect("DangNhap");
			return;
		}
		
		if(request.getParameter("buy") != null) {
			String maSach = request.getParameter("maSach");
			if(maSach != null) {
				SachBo sachBo = new SachBo();
				Sach sach = null;
				try {
					sach = sachBo.getSachById(maSach);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (session.getAttribute("gh") == null) {
					GioHang gh = new GioHang();
					session.setAttribute("gh", gh);
				}
				GioHang gh = (GioHang) session.getAttribute("gh");
				gh.themSach(sach, 1);
				session.setAttribute("gh", gh);
			}
			response.sendRedirect("GioHang");
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
		
		RequestDispatcher rd = request.getRequestDispatcher("gio-hang.jsp");
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
