<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký chi tiết</title>
</head>
<body>
<span>${requestScope.unsuccessfulRegisMsg}</span>
<form action="DangKyChiTiet" method="post">
		<div>
			<label for="name">Họ tên:</label>
			<input id="name" name="name" type="text" value="${requestScope.name}">
			<span>${requestScope.nameError}</span>
		</div>
		<div>
			<label for="address">Địa chỉ:</label>
			<input id="address" name="address" type="text" value="${requestScope.address}">
			<span>${requestScope.addressError}</span>
		</div>
		<div>
			<label for="phone">Số điện thoại:</label>
			<input id="phone" name="phone" type="text" value="${requestScope.phone}">
			<span>${requestScope.phoneError}</span>
		</div>
		<!-- 
		<div>
			<label for="email">Email:</label>
			<input id="email" name="email" type="email" value="${email}">
			<span>${emailError}</span>
		</div>
		 -->
		<div>
			<label for="username">Tên đăng nhập:</label>
			<input id="username" name="username" type="text" value="${requestScope.username}">
			<span>${requestScope.usernameError}</span>
		</div>
		<div>
			<label for="pass">Mật khẩu:</label>
			<input id="pass" name="pass" type="password" value="${requestScope.pass}">
			<span>${requestScope.passError}</span>
		</div>
		<div>
			<label for="repass">Xác nhận mật khẩu:</label>
			<input id="repass" name="repass" type="password">
			<span>${requestScope.repassError}</span>
		</div>
		<div>
			<button type="submit">Đăng ký</button>
		</div>
	</form>
</body>
</html>