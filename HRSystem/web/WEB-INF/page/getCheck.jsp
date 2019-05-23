<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/23
  Time: 9:25
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
    <script src="js/jquery-3.1.0.js"></script>
</head>
<body>
        <div>
            <table>
                <tr>
                    <th>上班打卡时间</th>
                    <th>下班打卡时间</th>
                </tr>
                <c:if test="${not empty sessionScope.checks}">
                <c:forEach items="${sessionScope.checks}" var="check" >
                <tr>
                    <td>${check.ch_start_time}</td>
                    <td>${check.ch_end_time}</td>
                </tr>
                </c:forEach>
                </c:if>
            </table>
        </div>

</body>
</html>
