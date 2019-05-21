<%@ page import="com.iotek.model.Bond" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/21
  Time: 11:32
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
<%
    List<Bond> bonds= (List<Bond>) session.getAttribute("messages");
%>
<div>
    <table>
        <tr>
            <th>部门名字</th>
            <th>职位名称</th>
            <th>员工姓名</th>
            <th>电话</th>
        </tr>
        <%
            if(bonds!=null&&bonds.size()!=0){
                for (Bond bond : bonds) {
        %>
        <tr>
            <td><%=bond.getDepartment().getDep_name()%></td>
            <td><%=bond.getPosition().getPos_name()%></td>
            <td><%=bond.getEmployee().getEmp_name()%></td>
            <td><%=bond.getEmployee().getEmp_phone()%></td>
        </tr>
        <%
            }
        }else {
        %>
        <tr>
            <td colspan="4">没有通讯录！</td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
