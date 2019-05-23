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
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        window.onload = function(){
            function getDate(){
                debugger;
                var today = new Date();
                var date;
                date = (today.getFullYear()) +"-" + (today.getMonth() + 1 ) + "-" + today.getDate() + " " + today.toLocaleTimeString('chinese', { hour12: false });
                return date;
            }
            window.setInterval(function(){
                document.getElementById("getBookTime").value=getDate();
            }, 1000);
            window.setInterval(function(){
                document.getElementById("getTime").value=getDate();
            }, 1000);
        }
    </script>
</head>
<body>
<div id="nav">
    <a>查看个人信息</a>
    <a href="getMessage">查看通讯录</a>
    <a>查看培训通知</a>
    <a>查看奖惩明细</a>
    <a>查看薪资明细</a>
</div>

<div>
    <form action="checkOn" method="post">
        <input type="hidden" name="emp_id" value="${sessionScope.employee.emp_id}">
        <input type="text"  name="ch_start_time" id="getBookTime" value="" readonly>
        <input type="submit" value="上班打卡">
    </form>
    <form action="checkOff" method="post">
        <input type="hidden" name="emp_id" value="${sessionScope.employee.emp_id}">
        <input type="text"  name="ch_end_time" id="getTime" value="" readonly>
        <input type="submit" value="下班打卡">
    </form>
</div>

</body>
</html>
