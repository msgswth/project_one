<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Bond" %><%--
  Created by IntelliJ IDEA.
  User: 90314
  Date: 2019/5/20
  Time: 15:23
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
<%
    List<Bond> bonds= (List<Bond>) session.getAttribute("bonds");
%>
<div>
    <table>
        <tr>
            <th>部门名字</th>
            <th>创建时间</th>
            <th>职位名称</th>
            <th>员工姓名</th>
            <th>更新</th>
            <th>删除</th>
            <th>添加</th>
        </tr>
        <%
        if(bonds!=null&&bonds.size()!=0){
            for (Bond bond : bonds) {
        %>
        <tr>
            <td><%=bond.getDepartment().getDep_name()%></td>
            <td><%=bond.getDepartment().getDep_time()%></td>
            <td><%=bond.getPosition().getPos_name()%></td>
            <td><%=bond.getEmployee().getEmp_name()%></td>
            <td>
                <input type="button" value="更新" class="update">
            </td>
            <td>

            </td>
            <td>

            </td>
        </tr>
        <%
            }
        }else {
        %>
        <tr>
            <td colspan="6">还没有任何部门或职位！</td>
            <td>
                <input type="button" value="添加">
            </td>
        </tr>
        <%
        }
        %>
    </table>
</div>

<div id="content">

</div>

</body>
</html>
