<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/08/29
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Category</title>
</head>
<body>
<h3>List Category</h3>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Category Id</th>
        <th>Category Name</th>
        <th>Category Description</th>
        <th>Category Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCategory}" var="cat" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${cat.categoryId}</td>
            <td>${cat.categoryName}</td>
            <td>${cat.categoryDescription}</td>
            <td>${cat.categoryStatus?"Active":"InActive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/categoryController/initUpdate?categoryId=${cat.categoryId}">Update</a>
                <a href="<%=request.getContextPath()%>/categoryController/delete?categoryId=${cat.categoryId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/categoryController/initCreate">Add New Category</a>
</body>
</html>
