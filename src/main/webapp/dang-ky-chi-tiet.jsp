<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký chi tiết</title>
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
<div class="row justify-content-center">
	<div class="col-sm-auto">
	<div class="text-center">
		<span class="fw-light text-danger">${requestScope.unsuccessfulRegisMsg}</span>
	</div>
	<form class="px-2" action="DangKyChiTiet" method="post">
			<div>
				<h2>Đăng ký tài khoản</h2>
			</div>
			<div class="mb-3">
				<label class="form-label" for="name">Họ tên:</label>
				<input class="form-control" id="name" name="name" type="text" value="${requestScope.name}">
				<span class="form-text">${requestScope.nameError}</span>
			</div>
			<div class="mb-3">
				<label class="form-label" for="address">Địa chỉ:</label>
				<input class="form-control" id="address" name="address" type="text" value="${requestScope.address}">
				<span class="form-text">${requestScope.addressError}</span>
			</div>
			<div class="mb-3">
				<label class="form-label" for="phone">Số điện thoại:</label>
				<input class="form-control" id="phone" name="phone" type="text" value="${requestScope.phone}">
				<span class="form-text">${requestScope.phoneError}</span>
			</div>
			<!-- 
			<div>
				<label for="email">Email:</label>
				<input id="email" name="email" type="email" value="${email}">
				<span>${emailError}</span>
			</div>
			 -->
			<div class="mb-3">
				<label class="form-label" for="username">Tên đăng nhập:</label>
				<input class="form-control" id="username" name="username" type="text" value="${requestScope.username}">
				<span class="form-text">${requestScope.usernameError}</span>
			</div>
			<div class="mb-3">
				<label class="form-label" for="pass">Mật khẩu:</label>
				<input class="form-control" id="pass" name="pass" type="password" value="${requestScope.pass}">
				<span class="form-text">${requestScope.passError}</span>
			</div>
			<div class="mb-3">
				<label class="form-label" for="repass">Xác nhận mật khẩu:</label>
				<input class="form-control" id="repass" name="repass" type="password">
				<span class="form-text">${requestScope.repassError}</span>
			</div>
			<div class="text-center">
				<button class="btn btn-primary" type="submit">Đăng ký</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>