<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Sach"%>

<%@page import="model.Loai"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lịch sử mua hàng</title>
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
	<div class="row">
		<div class="col-sm-3">

			<c:forEach var="loai" items="${dsLoai}">
				<a href="TrangChu?ml=${loai.getMaLoai() }">${loai.getTenLoai() }</a><br>
			</c:forEach>
		</div>
		<div class="col-sm-9">
			
			<table class="table table-striped caption-top">
				<caption>Lịch sử mua hàng</caption>
			
				<thead>
					<tr>
						<th>Mã hóa đơn</th>
						<th>Mã sách</th>
						<th>Tên sách</th>
						<th>Giá</th>
						<th>Số lượng mua</th>
						<th>Thành tiền</th>
						<th>Ngày mua</th>
						<th>Thanh toán</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${lichSuMuaHang}" var="ls">
						<tr>
							<td>${ls.getMaHD()}</td>
							<td>${ls.getMaSach()}</td>
							<td>${ls.getTenSach()}</td>
							<td>${ls.getGia()}</td>
							<td>${ls.getSoLuongMua()}</td>
							<td>${ls.getThanhTien()} VNĐ</td>
							<td>${ls.getNgayMuaString()}</td>
							<td>${ls.isDaMua()? 'Đã thanh toán' : 'Chưa thanh toán'}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<nav aria-label="Page navigation example">
				<ul class="pagination flex-wrap">
					<c:forEach var="page" begin="1" end="${soLuongTrang}" step="1">
						<li class="page-item ${(currentPage == page)? 'active' : ''}"><a class="page-link" href="LichSuMuaHang?page=${page}">${page}</a></li>
					</c:forEach>
				</ul>
			</nav>
			
		</div>
	</div>
</body>
</html>