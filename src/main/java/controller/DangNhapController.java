package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.KhachHang;
import model.KhachHangBo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhap")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("un") != null) {
			response.sendRedirect("TrangChu");
			return;
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != null || password != null) {
//			if(username.equals("abc") && password.equals("123")) {
//				
//				session.setAttribute("un", username);
//				response.sendRedirect("TrangChu");
//				return;
//			} else {
//				response.sendRedirect("DangNhap?authenFail=1");
//				return;
//			}
			KhachHangBo khachHangBo = new KhachHangBo();
			KhachHang kh = khachHangBo.kiemTraDangNhap(username, password);
		
			if(kh != null) {
				Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
				if(captcha != null) {
					String captchaAnswer = request.getParameter("captchaAnswer");
					if(captchaAnswer == null) {
						response.sendRedirect("DangNhap");
						return;
					}
					if(captcha.isCorrect(captchaAnswer)) {
						
						session.setAttribute("un", kh);
						session.removeAttribute("soLanDangNhapThatBai");
						response.sendRedirect("TrangChu");
						return;
					} else {
						response.sendRedirect("DangNhap");
						return;
					}
				}
				
				session.setAttribute("un", kh);
				session.removeAttribute("soLanDangNhapThatBai");
				response.sendRedirect("TrangChu");
				return;
			} else {
				// Dang nhap that bai
				if(session.getAttribute("soLanDangNhapThatBai") == null) {
					session.setAttribute("soLanDangNhapThatBai", (Integer) 0);
					
				}
				Integer soLanDangNhapThatBai = (Integer) session.getAttribute("soLanDangNhapThatBai");
				soLanDangNhapThatBai++;
				session.setAttribute("soLanDangNhapThatBai", soLanDangNhapThatBai);
				response.sendRedirect("DangNhap?authenFail=1");
				return;
			}
		}
		
		if(request.getParameter("authenFail") != null) {
			request.setAttribute("authenMsg", "Thông tin đăng nhập không đúng");
		}
		
		String successfulRegis = request.getParameter("successfulRegis");
		if(successfulRegis != null) {
			request.setAttribute("successfulRegisMsg", "Đăng ký thành công");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("dang-nhap.jsp");
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
