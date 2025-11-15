<%@page import="model.SachCuaGioHang"%>
<%@page import="model.GioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String maSach = request.getParameter("maSach");
	if(maSach == null) {
		response.sendRedirect("gio-hang.jsp");
	} else {
		String soLuongSachTxt = request.getParameter("soLuongSach");
		if(soLuongSachTxt == null || (Integer.parseInt(soLuongSachTxt)) <= 0) {
			response.sendRedirect("gio-hang.jsp");
		} else {
			int soLuongSach = Integer.parseInt(soLuongSachTxt);
			if(session.getAttribute("gh") != null) {
				GioHang gh = (GioHang) session.getAttribute("gh");
				for(SachCuaGioHang sachCuaGioHang : gh.getDsSach()) {
					if(sachCuaGioHang.getSach().getMaSach().equals(maSach)) {
						sachCuaGioHang.setSoLuong(soLuongSach);
						
						break;
					}
				}
				session.setAttribute("gh", gh);
				response.sendRedirect("gio-hang.jsp");
			}
		}
	}
%>
</body>
</html>