<%@page import="infra.MD5Encoder"%>
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
	MD5Encoder md5Encoder = new MD5Encoder();
	//String input = "helloWorld";
	//String hash = md5Encoder.encode(input);
	//out.print(hash);
	out.print(md5Encoder.verify("helloWorld", "1a833da63a6b7e20098dae06d06602e1"));
%>
</body>
</html>