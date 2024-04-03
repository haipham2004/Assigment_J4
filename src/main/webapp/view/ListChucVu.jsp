<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-25
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <a href="/viewAddChucVu" class="btn btn-success">ViewAdd</a>
    <table class="table">
       <thead>
       <th>ID</th>
       <th>Ma</th>
       <th>Tên</th>
       <th>Action</th>
       </thead>
        <tbody>
        <c:forEach items="${list}" var="mtam">
       <tr>
           <td>${mtam.id}</td>
           <td>${mtam.ma}</td>
           <td>${mtam.ten}</td>
           <td>
               <a href="/DetailNSX?id=${mtam.id}" class="btn btn-danger">Detail</a>
               <a href="/viewUpdateChucVu?id=${mtam.id}" class="btn btn-danger">Update</a>
               <a href="/DeleteNSX?id=${mtam.id}" class="btn btn-danger">Delete</a>
           </td>
       </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
