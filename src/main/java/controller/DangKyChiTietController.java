package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.KhachHang;
import model.KhachHangBo;

/**
 * Servlet implementation class DangKyChiTietController
 */
@WebServlet("/DangKyChiTiet")
public class DangKyChiTietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyChiTietController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if(email == null) {
			response.sendRedirect("DangKy");
			return;
		}
		String unsuccessfulRegis = request.getParameter("unsuccessfulRegis");
		if(unsuccessfulRegis != null) {
			request.setAttribute("unsuccessfulRegisMsg", "Đăng ký không thành công!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("dang-ky-chi-tiet.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if(email == null) {
			response.sendRedirect("DangKy");
			return;
		}
		
		 String hoTen = request.getParameter("name");
		 String diaChi = request.getParameter("address");
		 String soDienThoai = request.getParameter("phone");		 
		 String tenDangNhap = request.getParameter("username");
		 String pass = request.getParameter("pass");
		 String repass = request.getParameter("repass");
		 
		 if(hoTen == null || diaChi == null || soDienThoai == null || tenDangNhap == null || pass == null || repass == null) {
			 response.sendRedirect("DangKyChiTiet");
			 return;
		 }
		 
		 boolean valid = true;
		 
		 if(hoTen.isBlank()) {
			 String error = "Họ tên không được để trống";
			 request.setAttribute("nameError", error);
			 
			 valid = false;
		 }
		 if(diaChi.isBlank()) {
			 String error = "Địa chỉ không được để trống";
			 request.setAttribute("addressError", error);
			
			 valid = false;
		 }
		 if(!soDienThoai.matches("^0\\d{9}$")) {
			 String error = "Định dạng số điện thoại chưa đúng";
			 request.setAttribute("phoneError", error);
			 
			 valid = false;
		 }

		 if(tenDangNhap.isBlank() || tenDangNhap.length() < 3) {
			 String error = "Tên đăng nhập không trống và phải có ít nhất 3 ký tự";
			 request.setAttribute("usernameError", error);
			 
			 valid = false;
		 }
		 if(pass.isBlank() || pass.length() < 3) {
			 String error = "Mật khẩu không trống và phải có ít nhất 3 ký tự";
			 request.setAttribute("passError", error);
			 
			 valid = false;
		 }
		 if(!repass.equals(pass)) {
			 String error = "Mật khẩu không khớp";
			 request.setAttribute("repassError", error);
			 valid = false;
		 }
		 
		 if(!valid) {
			 request.setAttribute("name", hoTen);
			 request.setAttribute("address", diaChi);
			 request.setAttribute("phone", soDienThoai);
			 request.setAttribute("username", tenDangNhap);
			 request.setAttribute("pass", pass);
			 RequestDispatcher rd = request.getRequestDispatcher("dang-ky-chi-tiet.jsp");
			 rd.forward(request, response);
			 return;
		 }
		 
		 KhachHangBo khachHangBo = new KhachHangBo();
		 KhachHang khachHang = new KhachHang(hoTen, diaChi, soDienThoai, email, tenDangNhap, pass);
		 boolean success = khachHangBo.createKhachHang(khachHang);
		 if(success == false) {
			 response.sendRedirect("DangKyChiTiet?unsuccessfulRegis");
			 return;
		 }
		 session.removeAttribute("email");
		 response.sendRedirect("DangNhap?successfulRegis");
		 return;
	}

}
