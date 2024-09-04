<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/08/29
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Product</title>
</head>
<body>
<h3>Add New Product</h3>
<form:form modelAttribute="productNew" action="${pageContext.request.contextPath}/productController/create" method="post">
    <form:label path="productName" for="productName">Product Name</form:label>
    <form:input path="productName" id="productName"/><br/>
    <form:label path="productDescription" for="productDescription">Product Description</form:label>
    <form:input path="productDescription" id="producproductDescriptiontName"/><br/>
    <form:label path="productPrice" for="productPrice">Product Price</form:label>
    <form:input type="number" path="productPrice" id="productPrice"/><br/>
    <form:label path="imageUrl" for="prodimageUrluctName">Product Image</form:label>
    <form:input path="imageUrl" id="imageUrl"/><br/>

    <form:label path="category" for="category">Choose Category</form:label>
    <select id="category" name="category.categoryId">
        <c:forEach items="${listCategories}" var="cat">
            <option value="${cat.categoryId}">${cat.categoryName}</option>
        </c:forEach>
    </select><br/>
    <form:label path="createdAt" for="createdAt">Product CreatedAt</form:label>
    <form:input type="date" path="createdAt" id="createdAt"/><br/>
    <form:label path="productStatus">Product Status</form:label>
    <form:radiobutton path="productStatus" value="true" id="active"/>Active
    <form:radiobutton path="productStatus" value="false" id="InActive"/>InActive<br/>
    <input type="submit" value="Creat">

</form:form>

</body>
</html>
