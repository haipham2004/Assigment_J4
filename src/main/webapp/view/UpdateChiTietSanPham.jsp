<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-25
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="/UpdateChiTietSanPham?id=${mtam.id}" method="post">
        <div class="mt-3">
            <lable>Mã sản phẩm</lable>
            <select selected class="form-select" aria-label="Default select example" name="sanPham.id">
                <option value="${mtam.sanPham.id}">${mtam.sanPham.ten}</option>
                <c:forEach items="${listSP}" var="a">
                    <option value="${a.id}">${a.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-3">
            <lable>Mã nhà sản xuất</lable>
            <select selected class="form-select" aria-label="Default select example" name="nhaSanXuat.id">
                <option value="${mtam.nhaSanXuat.id}">${mtam.nhaSanXuat.ten}</option>
                <c:forEach items="${listNSX}" var="a">
                    <option value="${a.id}">${a.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-3">
            <lable>Mã màu sắc</lable>
            <select selected class="form-select" aria-label="Default select example" name="mauSac.id">
                <option value="${mtam.mauSac.id}">${mtam.mauSac.ten}</option>
                <c:forEach items="${listMS}" var="a">
                    <option value="${a.id}">${a.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mt-3">
            <lable>Mã dòng sản phẩm</lable>
            <select selected class="form-select" aria-label="Default select example" name="dongSanPham.id">
            <option selected value="${mtam.dongSanPham.id}">${mtam.dongSanPham.ten}</option>
            <c:forEach items="${listDSP}" var="a">
                <option value="${a.id}">${a.ten}</option>
            </c:forEach>
            </select>
        </div>

        <div class="mt-3">
            <lable>Năm bán hàng</lable>
            <input type="text" class="form-control" name="namBH" value="${mtam.namBH}">
        </div>
        <div class="mt-3">
            <lable>Mô tả</lable>
            <input type="text" class="form-control" name="moTa" value="${mtam.moTa}">
        </div>
        <div class="mt-3">
            <lable>Số lượng tồn</lable>
            <input type="text" class="form-control" name="soLuongTon" value="${mtam.soLuongTon}">
        </div>
        <div class="mt-3">
            <lable>Giá nhập</lable>
            <input type="text" class="form-control" name="giaNhap" value="${mtam.giaNhap}">
        </div>
        <div class="mt-3">
            <lable>Giá bán</lable>
            <input type="text" class="form-control" name="giaBan" value="${mtam.giaBan}">
        </div>

        <button type="submit" class="btn btn-success">Update</button>
    </form>
</div>
</body>
</html>
