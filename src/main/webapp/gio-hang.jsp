<%@page import="model.SachCuaGioHang"%>
<%@page import="model.GioHang"%>
<%@page import="model.Sach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
					<li class="nav-item"><a class="nav-link" href="GioHang">Giỏ
							hàng</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Thanh
							toán</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Lịch sử
							mua hàng</a></li>
	
					<li class="nav-item"><a class="nav-link" href="DangXuat">Đăng
							xuất</a></li>
					
					<li class="nav-item"><a class="nav-link" href="#">Xin
							chao: ${sessionScope.un.getHoTen()}</a></li>

				</ul>
				<form class="d-flex" action="TrangChu" method="get">
					<input class="form-control me-2" type="text"
						placeholder="Nhập tên sách hoặc tác giả..." name="txttk">
					<button class="btn btn-primary" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="row">
		<div class="col-sm-3">

			<c:forEach var="loai" items="${dsLoai}">
				<a href="TrangChu?ml=${loai.getMaLoai() }">${loai.getTenLoai() }</a>
				<br>
			</c:forEach>
		</div>
		<div class="col-sm-9">

			<h1>Giỏ hàng</h1>
			<form>
			<table class="table">
				<tr>
					<th>Chọn</th>
					<th>Ảnh</th>
					<th>Tên sách</th>
					<th>Tác giả</th>
					<th>Giá</th>
					<th>Số lượng</th>
					<th>Action</th>
				</tr>

				<c:if test="${sessionScope.gh != null }">
					<c:set var="gh" value="${sessionScope.gh}" scope="page"></c:set>
					<c:forEach var="sach" items="${gh.getDsSach()}">
						<tr>
							<td>
								<input type="checkbox" name="maSach" value="${sach.getSach().getMaSach()}">
							</td>
							<td><img alt="${sach.getSach().getTenSach()}"
								src="${sach.getSach().getAnh()}" width="50"></td>
							<td>${sach.getSach().getTenSach()}</td>
							<td>${sach.getSach().getTacGia()}</td>
							<td>${sach.getSach().getGia()}</td>
							<td>
								<p>${sach.getSoLuong()}</p>
								
								<div>
									<input type="text"
										value="${sach.getSoLuong()}"
										name="${sach.getSach().getMaSach()}">
									<button type="submit" 
										formaction="SuaSachTrongGioHang?maSach=${sach.getSach().getMaSach()}" 
										formmethod="post">Sửa</button>
								</div>
							</td>
							<td>
								<a href="XoaSachTrongGioHang?maSach=${sach.getSach().getMaSach()}">Xóa</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			
			<button type="submit" formaction="XoaSachTrongGioHang" formmethod="post">Xoá chọn</button>
			
			</form>
			
			<div class="d-flex justify-content-end">
				<c:if test="${sessionScope.gh != null && sessionScope.gh.getDsSach().size() != 0}">
					<a href="DatMua">Xác nhận đặt mua</a>
				</c:if>
			</div>
			
			<div>
				<span>Tổng tiền của giỏ hàng: </span> <span> <c:if
						test="${sessionScope.gh != null }">
						${gh.tongTien()}
					</c:if>
				</span>
			</div>
		</div>
</body>
</html>