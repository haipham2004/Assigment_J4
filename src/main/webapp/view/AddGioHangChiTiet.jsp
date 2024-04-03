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
    <form action="/AddGioHangChiTiet" method="post">
<%--        <div class="mt-3">--%>
<%--            <lable>ChiTietSamPham</lable>--%>
<%--            <input type="text" class="form-control" name="chiTietSanPham.id">--%>
<%--        </div>--%>
        <div class="mt-3">
            <lable>Số lượng</lable>
            <input type="text" class="form-control" name="soLuong">
        </div>
        <div class="mt-3">
            <lable>Đơn giá</lable>
            <input type="text" class="form-control" name="donGia">
        </div>
        <div class="mt-3">
            <lable>Đơn giá sau khi giảm</lable>
            <input type="text" class="form-control" name="donGiaKhiGiam">
        </div>
       <button type="submit" class="btn btn-success">Add</button>
    </form>
</div>
</body>
</html>
