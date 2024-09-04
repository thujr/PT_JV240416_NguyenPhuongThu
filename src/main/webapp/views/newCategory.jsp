<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/08/29
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Category</title>
</head>
<body>
<h3>Add New Category</h3>
<form:form modelAttribute="categoryNew" action="${pageContext.request.contextPath}/categoryController/create"
           method="post">
    <form:label path="categoryName" for="categoryName">Category Name</form:label>
    <form:input path="categoryName" id="categoryName"/><br/>
    <form:label path="categoryDescription" for="categoryDescription">Category Description</form:label>
    <form:input path="categoryDescription" id="categoryDescription"/><br/>
    <form:label path="categoryStatus">Category Status</form:label>
    <form:radiobutton path="categoryStatus" value="true" id="active"/>Active
    <form:radiobutton path="categoryStatus" value="false" id="inActive"/>InActive<br/>
    <input type="submit" value="Create">

</form:form>

</body>
</html>
