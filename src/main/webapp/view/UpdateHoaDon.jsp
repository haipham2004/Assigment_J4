<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-25
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="/UpdateHoaDon?id=${mtam.id}" method="post">
        <div class="mt-3">
            <lable>Mã</lable>
            <input type="text" class="form-control" name="ma" value="${mtam.ma}" >
        </div>
        <div class="mt-3">
            <lable>Khách Hàng</lable>
            <input type="text" class="form-control" name="khachHang.id" value="${mtam.khachHang.id}">
        </div>

        <div class="mt-3">
            <lable>Nhân viên</lable>
            <input type="text" class="form-control" name="nhanVien.id" value="${mtam.nhanVien.id}">
        </div>
        <div class="mt-3">
            <lable>Ngày nhận</lable>
            <input type="date" class="form-control" name="ngayTao" value="${mtam.ngayTao}">
        </div>
        <div class="mt-3">
            <lable>Ngày nhận</lable>
            <input type="date" class="form-control" name="ngayNhan" value="${mtam.ngayNhan}">
        </div>
        <div class="mt-3">
            <lable>Ngày thanh toán</lable>
            <input type="text" class="form-control" name="ngayThanhToan" value="${mtam.ngayThanhToan}">
        </div>
        <div class="mt-3">
            <lable>Ngày ship</lable>
            <input type="date" class="form-control" name="ngayShip" value="${mtam.ngayShip}">
        </div>
        <div class="mt-3">
            <lable>Người nhận</lable>
            <input type="text" class="form-control" name="tenNguoiNhan" value="${mtam.tenNguoiNhan}">
        </div>
        <div class="mt-3">
            <lable>Địa chỉ</lable>
            <input type="text" class="form-control" name="diaChi" value="${mtam.diaChi}">
        </div>
        <div class="mt-3">
            <lable>Số điện thoạ</lable>
            <input type="text" class="form-control" name="soDienThoai" value="${mtam.soDienThoai}">
        </div>
        <div class="mt-3">
            <lable>Tình trạng</lable>
            <input type="text" class="form-control" name="tinhTrang" value="${mtam.tinhTrang}">
        </div>
        <button type="submit" class="btn btn-success">Update</button>
    </form>
</div>
</body>
</html>
