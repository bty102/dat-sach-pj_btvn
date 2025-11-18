<%@page import="infra.EmailSender"%>
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
	EmailSender emailSender = new EmailSender();
	emailSender.send("22T1020329@husc.edu.vn", "phuoc dep zai", "Oi doi oi, oi doi oi, trinh la gi ma la trinh ai cham!");
%>
</body>
</html>