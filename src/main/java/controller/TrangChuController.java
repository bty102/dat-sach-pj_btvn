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

import model.Loai;
import model.LoaiBo;
import model.Sach;
import model.SachBo;

/**
 * Servlet implementation class TrangChuController
 */
@WebServlet("/TrangChu")
public class TrangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangChuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoaiBo loaiBo = new LoaiBo();
		List<Loai> dsLoai = null;
		try {
			dsLoai = loaiBo.getLoai();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("dsLoai", dsLoai);
		
		String maLoai = request.getParameter("ml");
		String txtTk = request.getParameter("txttk");
		String txtTrang = request.getParameter("trang");
		SachBo sachBo = new SachBo();
		List<Sach> dsSach = sachBo.getSach(1, 6);
		request.setAttribute("trangHienTai", 1);

		if(txtTrang != null) {
			int trang = Integer.parseInt(txtTrang);
			dsSach = sachBo.getSach(trang, 6);
			request.setAttribute("trangHienTai", trang);
		}
		
		request.setAttribute("mode", "all");
		request.setAttribute("soTrang", sachBo.getSoTrang(6));
		
	
		if(maLoai != null) {

			if(txtTrang != null) {
				int trang = Integer.parseInt(txtTrang);
				dsSach = sachBo.findByMaLoai(maLoai, trang, 6);
				request.setAttribute("trangHienTai", trang);
			} else {
				dsSach = sachBo.findByMaLoai(maLoai, 1, 6);
				request.setAttribute("trangHienTai", 1);
			}
			
			request.setAttribute("mode", "searchMaLoai");
			request.setAttribute("maLoai", maLoai);
			request.setAttribute("soTrang", sachBo.getSoTrangWhenFindByMaLoai(maLoai, 6));

		}
		if(txtTk != null) {
			if(txtTrang != null) {
				int trang = Integer.parseInt(txtTrang);
				dsSach = sachBo.findByTenSachOrTacGia(txtTk, trang, 6);
				request.setAttribute("trangHienTai", trang);
			} else {
				dsSach = sachBo.findByTenSachOrTacGia(txtTk, 1, 6);
				request.setAttribute("trangHienTai", 1);
			}
			
			request.setAttribute("mode", "searchTenSachOrTacGia");
			request.setAttribute("txtTk", txtTk);
			request.setAttribute("soTrang", sachBo.getSoTrangWhenFindByTenSachOrTacGia(txtTk, 6));
		} 
		
		request.setAttribute("dsSach", dsSach);
		
		RequestDispatcher rd = request.getRequestDispatcher("trang-chu.jsp");
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
