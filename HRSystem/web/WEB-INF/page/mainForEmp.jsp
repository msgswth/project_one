<%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/21
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<body>
<div id="nav">
    <a>查看个人信息</a>
    <a href="getMessage">查看通讯录</a>
    <a>查看培训通知</a>
    <a>查看奖惩明细</a>
    <a>考勤打卡</a>
    <a>查看薪资明细</a>
</div>

</body>
</html>
