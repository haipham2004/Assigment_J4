<%@ page import="org.hibernate.Session" %><%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-30
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ok</title>
</head>
<body>
<h5>Ok nhé</h5>
Tài kHoản: ${sessionScope.nhanVienTaiKhoan.tenDem}+${sessionScope.nhanVienTaiKhoan.ten}
</body>
</html>
