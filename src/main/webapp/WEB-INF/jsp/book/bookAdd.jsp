<%--
  Created by IntelliJ IDEA.
  User: Devil
  Date: 2019/12/11
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
书本新增
<f:form action="${ctx}/book/addBook" method="post" modelAttribute="book">
    书名：<f:input path="bookName"></f:input><f:errors path="bookName" cssClass="body"></f:errors> <br>
    价格：<f:input path="price"></f:input><f:errors path="price" cssClass="body"></f:errors> <br>
    <input type="submit" value="确定">
</f:form>

</body>
</html>
