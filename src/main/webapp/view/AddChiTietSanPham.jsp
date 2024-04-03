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
    <title>ADD</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="/AddChiTietSanPham" method="post">
        <div class="mt-3">
            <lable>Mã sản phẩm</lable>
            <input type="text" class="form-control" name="sanPham.id">
        </div>
        <div class="mt-3">
            <lable>Mã nhà sản xuất</lable>
            <input type="text" class="form-control" name="nhaSanXuat.id">
        </div>
        <div class="mt-3">
            <lable>Mã màu sắc</lable>
            <input type="text" class="form-control" name="mauSac.id">
        </div>
        <div class="mt-3">
            <lable>Mã dòng sản phẩm</lable>
            <input type="text" class="form-control" name="dongSanPham.id">
        </div>
        <div class="mt-3">
            <lable>Năm bán hàng</lable>
            <input type="text" class="form-control" name="namBH">
        </div>
        <div class="mt-3">
            <lable>Mô tả</lable>
            <input type="text" class="form-control" name="moTa">
        </div>
        <div class="mt-3">
            <lable>Số lượng tồn</lable>
            <input type="text" class="form-control" name="soLuongTon">
        </div>
        <div class="mt-3">
            <lable>Giá nhập</lable>
            <input type="text" class="form-control" name="giaNhap">
        </div>
        <div class="mt-3">
            <lable>Giá bán</lable>
            <input type="text" class="form-control" name="giaBan">
        </div>

       <button type="submit" class="btn btn-success">Add</button>
    </form>
</div>
</body>
</html>
