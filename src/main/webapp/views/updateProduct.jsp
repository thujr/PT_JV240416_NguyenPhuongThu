<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/08/29
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h3>Update Product</h3>
<form:form modelAttribute="productUpdate" action="${pageContext.request.contextPath}/productController/update"
           method="post">
    <form:label path="productId" for="productId">Product Id</form:label>
    <form:input path="productId" id="productId" readonly="true"/><br>

    <form:label path="productName" for="productName">Product Name</form:label>
    <form:input path="productName" id="productName"/><br>

    <form:label path="productDescription" for="productDescription">Product Created</form:label>
    <form:input path="productDescription" id="productproductDescriptionCreated"/><br>

    <form:label path="productPrice" for="productPrice">Product Price</form:label>
    <form:input type="number" path="productPrice" id="productPrice"/><br>

    <form:label path="imageUrl" for="imageUrl">Product Image</form:label>
    <form:input path="imageUrl" id="imageUrl"/><br/>


    <form:label path="categories" for="categories">Choose Categoy</form:label>
    <select id="categories" name="categories.catalogId">
        <c:forEach items="${listCategories}" var="cat">
            <option value="${cat.categoryId}">${cat.categoryName}</option>
        </c:forEach>
    </select><br/>

    <form:label path="createdAt" for="createdAt">Product CreatedAt</form:label>
    <form:input path="createdAt" id="createdAt"/><br/>

    <form:label path="productStatus" for="active">Product Status</form:label>
    <form:radiobutton path="productStatus" value="true" id="active"/>Active
    <form:radiobutton path="productStatus" value="false" id="InActive"/>Inactive<br/>

    <input type="submit" value="Update">
</form:form>

</body>
</html>
