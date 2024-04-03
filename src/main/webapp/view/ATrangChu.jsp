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
        <a class="navbar-brand" href="home">Hải Phạm</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.taiKhoan.isStaff==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Staff Account</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.taiKhoan.isManager==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="/Manager">Manager Account</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="#">Hello Garage</a>
                </li>
                <c:if test="${sessionScope.taiKhoan!=null}" >
                    <li class="nav-item">
                        <a class="nav-link" href="/Logout">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: red;font-weight: bold" href="#">Xin chào: ${sessionScope.taiKhoan.hoTen}</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.taiKhoan==null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/SLogin">Login</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="/SChangePassword">ChangePassword</a>
                </li>
            </ul>

            <form action="searchs" method="get" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="tenXe" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search..." value="">
                    <div class="input-group-append">
                        <button type="submit" style="background: aqua" class="btn btn-secondary btn-number">Search
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="show">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">3</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Auto Hải Phạm</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm xe nhập khẩu</p>
    </div>
</section>
<!--end of menu-->
<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">Category</a></li>
                    <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                <ul class="list-group category_block">
                    <c:forEach items="${listLX}" var="lx">
                        <li class="list-group-item text-white"><a style="color: darkgrey" href="/LoadLX?id=${lx.IDLX}">${lx.tenLoai}</a></li>
                    </c:forEach>

                </ul>
            </div>
            <%--            <div class="card bg-light mb-3">--%>
            <%--                <div class="card-header bg-success text-white text-uppercase">Last product</div>--%>
            <%--                <div class="card-body">--%>
            <%--                    <img class="img-fluid" src="${p.image}" />--%>
            <%--                    <h5 class="card-title">${p.name}</h5>--%>
            <%--                    <p class="card-text">${p.title}</p>--%>
            <%--                    <p class="bloc_left_price">${p.price} $</p>--%>
            <%--                </div>--%>
            <%--            </div>--%>
        </div>

        <div class="col-sm-9">
            <div class="row">
                <c:forEach items="${listX}" var="x">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <img class="card-img-top" src="${x.hinhAnh}" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title show_txt"><a href="/display?id=${x.ID}" title="View Product">${x.tenXe}</a></h4>
                                <p class="card-text show_txt">${x.moTa}</p>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">${x.gia} $</p>
                                    </div>
                                    <div class="col">
                                        <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
</div>

<!-- Footer -->
<footer class="text-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-lg-4 col-xl-3">
                <h5>About</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <p class="mb-0">
                    Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
                </p>
            </div>



            <div class="col-md-4 col-lg-3 col-xl-3">
                <h5>Contact</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><i class="fa fa-home mr-2"></i> My company</li>
                    <li><i class="fa fa-envelope mr-2"></i> bophamnb2004@gmail.com</li>
                    <li><i class="fa fa-phone mr-2"></i> 0334294889</li>
                    <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
                </ul>
            </div>
            <div class="col-12 copyright mt-3">
                <p class="float-left">
                    <a href="#">Back to top</a>
                </p>
                <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a> | <span>v. 1.0</span></p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
