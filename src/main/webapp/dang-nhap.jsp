<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
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
					<li class="nav-item"><a class="nav-link" href="gio-hang.jsp">Giỏ
							hàng</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Thanh
							toán</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Lịch sử
							mua hàng</a></li>
					<li class="nav-item"><a class="nav-link" href="DangNhap">Đăng
							nhập</a></li>

					
				</ul>
				
			</div>
		</div>
	</nav>
	<div class="row justify-content-center">
		<div class="col-6">
			<form action="DangNhap" method="post">
				<div>
					<h1 class="text-center">Đăng nhập</h1>
				</div>
				<div>
					<label class="form-label" for="username">Username:</label>
					<input class="form-control" type="text" name="username" id="username" placeholder="Enter username...">
				</div>
				<div>
					<label class="form-label" for="password">Password:</label>
					<input class="form-control" type="password" name="password" id="password" placeholder="Enter password...">
				</div>
				<div class="text-center text-danger">
					${authenMsg}
				</div>
				<div class="d-flex justify-content-center mt-2">
					<button class="btn btn-primary" type="submit">Đăng nhập</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>