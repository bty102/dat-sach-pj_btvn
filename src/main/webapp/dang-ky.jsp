<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="javascript:void(0)">Công ty sách</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#mynavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mynavbar">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link" href="TrangChu">Trang
							chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="GioHang">Giỏ hàng</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Thanh
							toán</a></li>
					<li class="nav-item"><a class="nav-link" href="LichSuMuaHang">Lịch sử
							mua hàng</a></li>

					<c:if test="${sessionScope.un == null }">
						<li class="nav-item"><a class="nav-link" href="DangNhap">Đăng
							nhập</a></li>
					</c:if>
								
					<c:if test="${sessionScope.un != null }">
						<li class="nav-item"><a class="nav-link" href="DangXuat">Đăng
								xuất</a></li>
					</c:if>
					<c:if test="${sessionScope.un == null }">
						<li class="nav-item">
								<a class="nav-link" href="DangKy">Đăng ký</a>
						</li>
					</c:if>
					<c:choose>
						<c:when test="${sessionScope.un == null }">
							<li class="nav-item"><a class="nav-link" href="#">Xin
							chao: unknown</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="#">Xin
							chao: ${sessionScope.un.getHoTen()}</a></li>
						</c:otherwise>
					</c:choose>
					
				</ul>
				<form class="d-flex" action="TrangChu" method="get">
					<input class="form-control me-2" type="text" placeholder="Nhập tên sách hoặc tác giả..." name="txttk">
					<button class="btn btn-primary" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
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
 <div class="row">
 	<div class="col-sm-auto">
		 <form class="px-2" action="DangKy" method="post">
		 	<div>
		 		<h2>Đăng ký tài khoản</h2>
		 	</div>
		 	<div class="row g-3 align-items-center">
		 		<div class="col-auto">
		 			<label class="col-form-label" for="email">Email:</label>
		 		</div>
		 		<div class="col-auto">
		 			<input class="form-control" type="text" name="email" id="email" value="${requestScope.email}">
		 		</div>
		 		<div class="col-auto">
		 			<span class="form-text text-danger">${emailErrorMsg}</span>
		 		</div>
		 	</div>
	 		<div class="">
	 		<button class="btn btn-primary mt-2" type="submit">Đăng ký</button>
	 		</div>
		 </form>
		 <c:if test="${success}">
		 <div class="mt-2 text-success">
		 	Thư đã được gửi đến email của bạn. Vui lòng kiểm tra email để thực hiện đăng ký tài khoản!
		 </div>
		 </c:if>
	 </div>
 </div>
</body>
</html>