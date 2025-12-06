<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	<form action="DangKy" method="post">
		<div>
			<label for="name">Họ tên:</label>
			<input id="name" name="name" type="text" value="${name}">
			<span>${nameError}</span>
		</div>
		<div>
			<label for="address">Địa chỉ:</label>
			<input id="address" name="address" type="text" value="${address}">
			<span>${addressError}</span>
		</div>
		<div>
			<label for="phone">Số điện thoại:</label>
			<input id="phone" name="phone" type="text" value="${phone}">
			<span>${phoneError}</span>
		</div>
		<div>
			<label for="email">Email:</label>
			<input id="email" name="email" type="email" value="${email}">
			<span>${emailError}</span>
		</div>
		<div>
			<label for="username">Tên đăng nhập:</label>
			<input id="username" name="username" type="text" value="${username}">
			<span>${usernameError}</span>
		</div>
		<div>
			<label for="pass">Mật khẩu:</label>
			<input id="pass" name="pass" type="password" value="${pass}">
			<span>${passError}</span>
		</div>
		<div>
			<label for="repass">Xác nhận mật khẩu:</label>
			<input id="repass" name="repass" type="password">
			<span>${repassError}</span>
		</div>
		<div>
			<button type="submit">Đăng ký</button>
		</div>
	</form>
 -->
 <form action="DangKy" method="post">
 	<div>
 		<label for="email">Email:</label>
 		<input type="text" name="email" id="email" value="${email}">
 		<span>${emailErrorMsg}</span>
 	</div>
 	<div>
 		<button type="submit">Đăng ký</button>
 	</div>
 </form>
 <c:if test="${success}">
 <div>
 	Thư đã được gửi đến email của bạn. Vui lòng kiểm tra email để thực hiện đăng ký tài khoản!
 </div>
 </c:if>
</body>
</html>