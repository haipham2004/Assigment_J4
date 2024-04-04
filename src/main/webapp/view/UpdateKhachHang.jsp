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
    <form action="/UpdateKhachHang?id=${mtam.id}" method="post">
        <div class="mt-3">
            <lable>Mã</lable>
            <input type="text" class="form-control" name="ma" value="${mtam.ma}">
        </div>
        <div class="mt-3">
            <lable>Tên</lable>
            <input type="text" class="form-control" name="ten" value="${mtam.ten}">
        </div>
        <div class="mt-3">
            <lable>Tên đệm</lable>
            <input type="text" class="form-control" name="tenDem" value="${mtam.tenDem}">
        </div>
        <div class="mt-3">
            <lable>Họ</lable>
            <input type="text" class="form-control" name="ho" value="${mtam.ho}">
        </div>
        <div class="mt-3">
            <lable>Ngày sinh</lable>
            <input type="date" class="form-control" name="ngaySinh" value="${mtam.ngaySinh}">
        </div>
        <div class="mt-3">
            <lable>Địa chỉ</lable>
            <input type="text" class="form-control" name="diaChi" value="${mtam.diaChi}">
        </div>
        <div class="mt-3">
            <lable>Số điện thoại</lable>
            <input type="text" class="form-control" name="soDienThoai" value="${mtam.soDienThoai}">
        </div>
        <div class="mt-3">
            <lable>Mật khẩu</lable>
            <input type="text" class="form-control" name="matKhau" value="${mtam.matKhau}">
        </div>
        <div class="mt-3">
            <lable>Thành Phố</lable>
            <input type="text" class="form-control" name="thanhPho" value="${mtam.thanhPho}">
        </div>
        <div class="mt-3">
            <lable>Quốc gia</lable>
            <input type="text" class="form-control" name="quocGia" value="${mtam.quocGia}">
        </div>
        <button type="submit" class="btn btn-success">Update</button>
    </form>
</div>
</body>
</html>
