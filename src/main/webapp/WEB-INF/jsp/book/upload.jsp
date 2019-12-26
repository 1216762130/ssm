<%--
  Created by IntelliJ IDEA.
  User: Devil
  Date: 2019/12/14
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<form action="${ctx}/myFile/upload" method="post" enctype="multipart/form-data">
    书本id：<input type="text" name="bookId" value="${param.bookId}"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="上传">

</form>
</body>
</html>
