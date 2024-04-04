<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-30
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Xin chào: ${sessionScope.nhanVienTaiKhoan.ten}-${sessionScope.nhanVienTaiKhoan.roles}</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <p>HAHA2</p>
                <c:if test="${sessionScope.nhanVienTaiKhoan.isStaff==1}">
                    <ul>
                        <li>
                            <a href="/HienThiChiTietSanPham" class="btn btn-success">Quản lí Sản Phẩm</a>
                            <a href="/HienThiNhanVien" class="btn btn-success">Quản lí Nhân Viên</a>
                            <a href="/HienThiKhachHang" class="btn btn-success">Quản lí Khách Hàng</a>
                            <a href="/HienThiHoaDon" class="btn btn-success">Quản lí Hoa Don</a>
                            <a href="/HienThiDongSP" class="btn btn-success">Quản lí dòng sản phẩm</a>
                        </li>
                    </ul>

                </c:if>
                <c:if test="${sessionScope.nhanVienTaiKhoan.isStaff==0}">
                    <li class="nav-item">
                        <a href="">Quản lí Sản Phẩm</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="#">HAHA</a>
                </li>
                <c:if test="${sessionScope.taiKhoan!=null}" >
                    <li class="nav-item">
                        <a class="nav-link" href="/Logout">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: red;font-weight: bold" href="#">Xin chào: ${sessionScope.nhanVienTaiKhoan.ten}</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<div class="container" >
    <img src="https://png.pngtree.com/thumb_back/fh260/background/20230408/pngtree-rainbow-curves-abstract-colorful-background-image_2164067.jpg"
         class="img-fluid" width="1500px" height="600px" alt="">
</div>

</body>
</html>
