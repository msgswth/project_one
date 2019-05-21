<%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/15
  Time: 15:53
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
<fieldset>
    <legend>管理员登录</legend>
    <form action="empLogin" method="post">
        账号：<input type="text" name="emp_name" required><br>
        密码：<input type="text" name="emp_pass" required><br>
        <input type="submit" value="登录">
    </form>
</fieldset>

</body>
</html>
