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
		if(session.getAttribute("gh") != null) {
			GioHang gh = (GioHang) session.getAttribute("gh");
			gh.xoaSach(maSach);
			session.setAttribute("gh", gh);
		}
		response.sendRedirect("gio-hang.jsp");
	}
	
%>
</body>
</html>