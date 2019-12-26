<%--
  Created by IntelliJ IDEA.
  User: Devil
  Date: 2019/12/11
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/head.jsp"%>
<html>
<head>
    <title>书本查询</title>
</head>
<body>
<table border="1"width="99%">
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>价格</td>
        <td>操作</td>
    </tr>

<c:forEach items="${bookList}" var="b">
    <tr>
        <td>${b.bookId}</td>
        <td>${b.bookName}</td>
        <td>${b.price}</td>
        <td><img src="${ctx}/myFile/download?fileId=${b.img}" height="100px"></td>
        <td>
            <a href="${ctx}/book/toUpload?bookId=${b.bookId}">上传图片</a>
        </td>
    </tr>
</c:forEach>

</table>




</body>

</html>
