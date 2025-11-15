package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GioHang;

/**
 * Servlet implementation class SuaGioHangController
 */
@WebServlet("/SuaSachTrongGioHang")
public class SuaSachTrongGioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSachTrongGioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("gh") != null) {
			GioHang gh = (GioHang) session.getAttribute("gh");
			String maSach = request.getParameter("maSach");
			String txtSoLuongSua = request.getParameter(maSach);
			if(maSach != null && txtSoLuongSua != null) {
				try {
					int soLuongSua = Integer.parseInt(txtSoLuongSua);
					gh.suaSoLuong(maSach, soLuongSua);
					session.setAttribute("gh", gh);
				} catch(NumberFormatException e) {
					
				}
			}
			
		}
		response.sendRedirect("GioHang");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
