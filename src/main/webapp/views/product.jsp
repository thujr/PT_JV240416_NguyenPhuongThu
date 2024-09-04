<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/08/29
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h3>List Product</h3>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Product Price</th>
        <th>Product ImageUrl</th>
        <th>Product CreatedAt</th>
        <th>Category Name</th>
        <th>Product Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="pro" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${pro.productId}</td>
            <td>${pro.productName}</td>
            <td>${pro.productDescription}</td>
            <td>${pro.productPrice}</td>
            <td>${pro.imageUrl}</td>
            <td>${pro.createdAt}</td>
            <td>${pro.category.categoryName}</td>
            <td>${pro.productStatus?"Active":"InActive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/categoryController/initUpdate?productId=${pro.productId}">Update</a>
                <a href="<%=request.getContextPath()%>/productController/delete?productId=${pro.productId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/productController/initCreate">Add new Product</a>
</body>
</html>
