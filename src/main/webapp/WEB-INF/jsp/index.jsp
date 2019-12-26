<%--
  Created by IntelliJ IDEA.
  User: Devil
  Date: 2019/12/10
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="r" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <%@include file="/common/head.jsp" %>
    <title>Title</title>
</head>
<body>

<%--<img src="<%= request.getContextPath()%>/images/1.jpg">--%>

<h1>
    <t:message code="title"></t:message>
</h1>


<a href="${ctx}/book/toAdd"><t:message code="add.lable"></t:message></a>

<a href="${ctx}/book/listBook"><t:message code="list.lable"></t:message></a>

<div>
    <r:hasRole name="管理员">
        <a href="${ctx}/book/listAll">查询全部</a>
    </r:hasRole>
    <r:hasPermission name="bookmanager:book:edit">
        <a href="${ctx}/test/test1">@ResponseBody</a>
    </r:hasPermission>
    <a href="${ctx}/test/test2">@RestController</a>
    <a href="${ctx}/book/listListMap">ListMap</a>
    <a href="${ctx}/book/listMap?bookId=1">Map</a>
    <a href="${ctx}/book/listSingerBook?bookId=3">Book</a>
</div>


<div>
    <a href="${ctx}/change?locale=zh">中文</a>
    <a href="${ctx}/change?locale=en">English</a>
</div>

<div> <a href="${ctx}/sysUser/logout">退出系统</a></div>


</body>
</html>
