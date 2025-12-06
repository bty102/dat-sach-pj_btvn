<%@page import="java.util.Date"%>
<%@page import="java.time.temporal.TemporalAccessor"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="infra.OTPGenerator"%>
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
	OTPGenerator otpGenerator = new OTPGenerator();
	out.print(otpGenerator.generate());
	
%>
</body>
</html>